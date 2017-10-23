package walkingdevs.http;

import java.io.IOException;
import java.io.OutputStream;

public interface HttpResponse {
    Status status();

    Headers headers();

    Body body();

    void writeFormattedTo(OutputStream outputStream) throws IOException;

    static HttpResponse mk(Status status, Headers headers, Body body) {
        return new HttpResponseImpl(
            status,
            headers,
            body
        );
    }
}