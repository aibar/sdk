package walkingdevs.http;

import java.io.IOException;
import java.io.OutputStream;

public interface HttpResponse {
    Status status();

    Headers headers();

    Body body();

    static HttpResponse mk(Status status, Headers headers, Body body) {
        return new HttpResponseImpl(
            status,
            headers,
            body
        );
    }

    void writeTo(OutputStream outputStream) throws IOException;

}