package walkingdevs.http11;

class HttpResponseImpl {
    int status() {
        return status;
    }

    String statusMessage() {
        return statusMessage;
    }

    Headers headers() {
        return headers;
    }

    Body body() {
        return body;
    }

    HttpResponseImpl(int status, String statusMessage, Headers headers, Body body) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.headers = headers;
        this.body = body;
    }

    private final int status;
    private final String statusMessage;
    private final Headers headers;
    private final Body body;
}