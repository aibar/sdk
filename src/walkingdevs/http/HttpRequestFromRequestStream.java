package walkingdevs.http;

import java.io.InputStream;

class HttpRequestFromRequestStream extends HttpRequestImpl {
    HttpRequestFromRequestStream(InputStream is) {
        super(
            null,
            null,
            null,
            null
        );
    }
}