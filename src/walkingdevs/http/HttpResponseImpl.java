package walkingdevs.http;

import walkingdevs.str.Str;

import java.io.IOException;
import java.io.OutputStream;

class HttpResponseImpl implements HttpResponse {
    public Status status() {
        return status;
    }

    public Headers headers() {
        return headers;
    }

    public Body body() {
        return body;
    }

    public void writeFormattedTo(OutputStream os) throws IOException {
        os.write(
            Str.mk("" +
                "HTTP/1.1 " +
                status.code() +
                " " +
                status.message()
            ).bytes()
        );
        headers.writeFormattedTo(os);
        os.write(
            Str.mk(
                "\r\n\r\n"
            ).bytes()
        );
        body.writeTo(os);
    }

    HttpResponseImpl(Status status, Headers headers, Body body) {
        this.status = status;
        this.headers = headers;
        this.body = body;
    }
    private final Status status;
    private final Headers headers;
    private final Body body;
}