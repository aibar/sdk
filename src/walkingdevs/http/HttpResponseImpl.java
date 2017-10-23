package walkingdevs.http;

import java.io.IOException;
import java.io.OutputStream;

class HttpResponseImpl implements HttpResponse {
    public Status status() {
        return null;
    }

    public Headers headers() {
        return null;
    }

    public Body body() {
        return null;
    }

    @Override
    public void writeTo(OutputStream outputStream) throws IOException {

    }

    HttpResponseImpl(Status status, Headers headers, Body body) {
    }
}