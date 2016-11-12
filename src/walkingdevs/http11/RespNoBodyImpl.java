package walkingdevs.http11;

class RespNoBodyImpl implements RespNoBody {
    public int status() {
        return status;
    }

    public String statusMsg() {
        return statusMsg;
    }

    public HttpHeaders headers() {
        return headers;
    }

    RespNoBodyImpl(
        int status,
        String statusMsg,
        HttpHeaders headers
    ) {
        this.status = status;
        this.statusMsg = statusMsg;
        this.headers = headers;
    }

    private final int status;
    private final String statusMsg;
    private final HttpHeaders headers;
}