package walkingdevs.http11;

class RespImpl implements Resp {
    public int status() {
        return status;
    }

    public String statusMsg() {
        return statusMsg;
    }

    public Headers headers() {
        return headers;
    }

    public RespBody body() {
        return body;
    }

    RespImpl(
        int status,
        String statusMsg,
        Headers headers,
        RespBody body
    ) {
        this.status = status;
        this.statusMsg = statusMsg;
        this.headers = headers;
        this.body = body;
    }

    private final int status;
    private final String statusMsg;
    private final Headers headers;
    private final RespBody body;
}