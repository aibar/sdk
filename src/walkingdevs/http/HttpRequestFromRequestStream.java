package walkingdevs.http;

import java.io.InputStream;

class HttpRequestFromRequestStream extends HttpRequestImpl {
    HttpRequestFromRequestStream(InputStream is) {
        super(
            Version.parseFromRequest(is),
            Status.parseFromRequest(is),
            Headers.parseFromRequest(is),
            Body.parseFromRequest(is)
        );
    }
}