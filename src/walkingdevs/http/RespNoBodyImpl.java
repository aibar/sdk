package walkingdevs.http;

class RespNoBodyImpl implements RespNoBody {
    public int status() {
        return status;
    }

    public String statusMsg() {
        return statusMsg;
    }

    public Headers headers() {
        return headers;
    }

    RespNoBodyImpl(
        int status,
        String statusMsg,
        Headers headers
    ) {
        this.status = status;
        this.statusMsg = statusMsg;
        this.headers = headers;
    }

    private final int status;
    private final String statusMsg;
    private final Headers headers;
}