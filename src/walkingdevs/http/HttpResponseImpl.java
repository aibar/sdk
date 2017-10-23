package walkingdevs.http;

import walkingdevs.chset.Chset;
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

    public void writeTo(OutputStream os) throws IOException {
        os.write(Str.mk("HTTP/1.1 "
            + status.code()
            + " "
            + status.message()
            + headers.getString()
            + "\r\n\r\n"
            + body.getString()).bytes(Chset.UTF8()));
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