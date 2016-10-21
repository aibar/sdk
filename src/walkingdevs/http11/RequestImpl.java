package walkingdevs.http11;

import walkingdevs.Problems;
import walkingdevs.fun.Handler;
import walkingdevs.stream.BufferedIs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

class RequestImpl implements Request {
    public Response send() {
        HttpURLConnection connection = null;
        try {
            connection = tryToGetConnection();

            tryToSetConnectionProps(connection);
            setHeaders(connection);
            tryToSendBody(connection);

            return Response.mk(
                    tryToGetStatus(connection),
                    tryToGetStatusMsg(connection),
                    getHeaders(connection),
                    tryToGetBody(connection)
            );
        } catch (Exception fail) {
            throw Problems.weFucked(
                    String.format("%s: We tried hard, but Failed to send the request", uri),
                    fail
            );
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public Response send(Handler<BufferedIs> bodyIsHandler) {
        HttpURLConnection connection = null;
        try {
            connection = tryToGetConnection();

            tryToSetConnectionProps(connection);
            setHeaders(connection);
            tryToSendBody(connection);

            try (BufferedIs bufferedIs = BufferedIs.mk(tryToGetInputStream(connection), 8192)) {
                bodyIsHandler.handle(bufferedIs);
            }

            return Response.mk(
                    tryToGetStatus(connection),
                    tryToGetStatusMsg(connection),
                    getHeaders(connection),
                    Body.mkEmpty()
            );
        } catch (Exception fail) {
            throw Problems.weFucked(
                    String.format("%s: We tried hard, but Failed to send the request", uri),
                    fail
            );
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    // TODO: implement
    public void sendAsync(Handler<Response> responseHandler) {
        throw Problems.notImplemented();
    }

    // TODO: implement
    public void sendAsync(Handler<Response> responseHandler, Handler<BufferedIs> bodyIsHandler) {
        throw Problems.notImplemented();
    }

    RequestImpl(
            HttpURI uri,
            HttpMethod method,
            HttpHeaders headers,
            Body body,
            int readTimeout,
            int connectTimeout
    ) {
        this.uri = uri;
        this.method = method;
        this.headers = headers;
        this.body = body;
        this.readTimeout = readTimeout;
        this.connectTimeout = connectTimeout;
    }

    private final HttpURI uri;
    private final HttpMethod method;
    private final HttpHeaders headers;
    private final Body body;
    private final int readTimeout;
    private final int connectTimeout;

    private HttpURLConnection tryToGetConnection() {
        URLConnection raw;
        try {
            raw = new URL(uri.full()).openConnection();
        } catch (IOException fail) {
            throw Problems.weFucked(
                    String.format("%s: Failed to connect", uri),
                    fail
            );
        }
        if (!(raw instanceof HttpURLConnection)) {
            throw Problems.WTF(
                    String.format("%s: We are expecting HttpURLConnection, but get " + raw.getClass(), uri)
            );
        }
        // Now, it's Ok.
        return HttpURLConnection.class.cast(raw);
    }

    private void tryToSetConnectionProps(HttpURLConnection connection) {
        try {
            connection.setRequestMethod(method.name());
        } catch (ProtocolException fail) {
            throw Problems.weFucked(fail);
        }
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(false);
    }

    private void setHeaders(HttpURLConnection connection) {
        for (HttpHeader header : headers) {
            connection.addRequestProperty(header.name(), header.value());
        }
    }

    private HttpHeaders getHeaders(HttpURLConnection connection) {
        HttpHeaders headers = HttpHeaders.mk();
        for (Map.Entry<String, List<String>> field : connection.getHeaderFields().entrySet()) {
            if (field.getKey() != null) {
                for (String value : field.getValue()) {
                    headers.add(field.getKey(), value);
                }
            }
        }
        return headers;
    }

    private Body tryToGetBody(HttpURLConnection connection) {
        InputStream is = tryToGetInputStream(connection);
        if (is == null) {
            return Body.mkEmpty();
        }
        try (BufferedIs bufferedIs = BufferedIs.mk(is, 8192)) {
            return Body.mk(bufferedIs.bytes().copy());
        } catch (Exception fail) {
            throw Problems.weFucked(fail);
        }
    }

    private InputStream tryToGetInputStream(HttpURLConnection connection) {
        if (tryToGetStatus(connection) >= HttpURLConnection.HTTP_BAD_REQUEST) {
            return connection.getErrorStream();
        } else {
            try {
                return connection.getInputStream();
            } catch (IOException fail) {
                throw Problems.weFucked(
                        String.format("%s: For reasons unknown we didn't get inputStream", uri),
                        fail
                );
            }
        }
    }

    private int tryToGetStatus(HttpURLConnection connection) {
        try {
            return connection.getResponseCode();
        } catch (IOException fail) {
            throw Problems.weFucked(
                    String.format("%s: We Fucked when getting status code", uri),
                    fail
            );
        }
    }

    private String tryToGetStatusMsg(HttpURLConnection connection) {
        try {
            return connection.getResponseMessage();
        } catch (IOException fail) {
            throw Problems.weFucked(
                    String.format("%s: We Fucked when getting status message", uri),
                    fail
            );
        }
    }

    private void tryToSendBody(HttpURLConnection connection) {
        if (body.isEmpty()) {
            return;
        }
        InputStream content = new ByteArrayInputStream(new byte[]{});
        connection.setDoOutput(true);
        OutputStream output = null;
        try {
            output = connection.getOutputStream();
            BufferedIs.mk(content, 8192).write(output);
        } catch (IOException fail) {
            throw Problems.weFucked(
                    String.format("%s: Cannot send body", uri),
                    fail
            );
        } finally {
            try {
                content.close();
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}