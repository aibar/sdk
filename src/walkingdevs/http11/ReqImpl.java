package walkingdevs.http11;

import walkingdevs.bytes.BytesBuilder;
import walkingdevs.exceptions.Exceptions;
import walkingdevs.fun.Handler;
import walkingdevs.stream.BufferedIs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

class ReqImpl implements Req {
    public Resp send() {
        BytesBuilder bytesBuilder = BytesBuilder.mk();
        RespNoBody resp = send(bufferedIs -> {
            for (byte[] bytes : bufferedIs) {
                bytesBuilder.add(bytes);
            }
        });
        return Resp.mk(
            resp.status(),
            resp.statusMsg(),
            resp.headers(),
            RespBody.mk(bytesBuilder.get())
        );
    }

    public RespNoBody send(Handler<BufferedIs> bufferedIsHandler) {
        HttpURLConnection connection = null;
        try {
            connection = tryToGetConnection();
            tryToSetConnectionProps(connection);
            tryToSendBody(connection);
            try (InputStream is = tryToGetInputStream(connection)) {
                bufferedIsHandler.handle(BufferedIs.mk(is));
            }

            return RespNoBody.mk(
                tryToGetStatus(connection),
                tryToGetStatusMsg(connection),
                getHeaders(connection)
            );
        } catch (Exception fail) {
            throw Exceptions.weFucked(
                String.format("%s: We tried hard, but Failed to send the request", url),
                fail
            );
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    // TODO: implement
    public void sendAsync(Handler<Resp> responseHandler) {
        throw Exceptions.NotImplemented();
    }

    // TODO: implement
    public void sendAsync(Handler<Resp> responseHandler, Handler<BufferedIs> bodyIsHandler) {
        throw Exceptions.NotImplemented();
    }

    ReqImpl(
        Url url,
        Method method,
        Headers headers,
        Body body,
        int readTimeout,
        int connectTimeout
    ) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = body;
        this.readTimeout = readTimeout;
        this.connectTimeout = connectTimeout;
    }

    private final Url url;
    private final Method method;
    private final Headers headers;
    private final Body body;
    private final int readTimeout;
    private final int connectTimeout;

    private HttpURLConnection tryToGetConnection() {
        URLConnection raw;
        try {
            raw = new URL(url.full()).openConnection();
        } catch (IOException fail) {
            throw Exceptions.weFucked(
                String.format("%s: Failed to connect", url),
                fail
            );
        }
        if (!(raw instanceof HttpURLConnection)) {
            throw Exceptions.WTF(
                String.format("%s: We are expecting HttpURLConnection, but copy " + raw.getClass(), url)
            );
        }
        // Now, it's Ok.
        return HttpURLConnection.class.cast(raw);
    }

    private void tryToSetConnectionProps(HttpURLConnection connection) {
        try {
            connection.setRequestMethod(method.name());
        } catch (ProtocolException fail) {
            throw Exceptions.weFucked(fail);
        }
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(false);
    }

    private void setHeaders(HttpURLConnection connection) {
        for (Header header : headers) {
            connection.addRequestProperty(header.name(), header.value());
        }
    }

    private Headers getHeaders(HttpURLConnection connection) {
        Headers headers = Headers.mk();
        for (Map.Entry<String, List<String>> field : connection.getHeaderFields().entrySet()) {
            if (field.getKey() != null) {
                for (String value : field.getValue()) {
                    headers.add(field.getKey(), value);
                }
            }
        }
        return headers;
    }

    private InputStream tryToGetInputStream(HttpURLConnection connection) {
        if (tryToGetStatus(connection) >= HttpURLConnection.HTTP_BAD_REQUEST) {
            return connection.getErrorStream();
        } else {
            try {
                return connection.getInputStream();
            } catch (IOException fail) {
                throw Exceptions.weFucked(
                    String.format("%s: For reasons unknown we didn't copy the InputStream", url),
                    fail
                );
            }
        }
    }

    private int tryToGetStatus(HttpURLConnection connection) {
        try {
            return connection.getResponseCode();
        } catch (IOException fail) {
            throw Exceptions.weFucked(
                String.format("%s: We Fucked when getting status code", url),
                fail
            );
        }
    }

    private String tryToGetStatusMsg(HttpURLConnection connection) {
        try {
            return connection.getResponseMessage();
        } catch (IOException fail) {
            throw Exceptions.weFucked(
                String.format("%s: We Fucked when getting status message", url),
                fail
            );
        }
    }

    private void tryToSendBody(HttpURLConnection connection) {
        if (body.isEmpty()) {
            return;
        }
        connection.setDoOutput(true);
        try (OutputStream output = connection.getOutputStream()) {
            body.writeTo(output);
        } catch (IOException fail) {
            throw Exceptions.weFucked(
                String.format("%s: Cannot send body", url),
                fail
            );
        }
    }
}