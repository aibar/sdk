package walkingdevs.http11;

class ResponseImpl implements Response {
    public int status() {
        return status;
    }

    public String statusMsg() {
        return statusMsg;
    }

    public HttpHeaders headers() {
        return headers;
    }

    public Body body() {
        return body;
    }

    ResponseImpl(
            int status,
            String statusMsg,
            HttpHeaders headers,
            Body body
    ) {
        this.status = status;
        this.statusMsg = statusMsg;
        this.headers = headers;
        this.body = body;
    }

    private final int status;
    private final String statusMsg;
    private final HttpHeaders headers;
    private final Body body;
}