package walkingdevs.http11;

public interface Resp {
    int status();

    String statusMsg();

    HttpHeaders headers();

    RespBody body();

    static Resp mk(
        int status,
        String statusMsg,
        HttpHeaders headers,
        RespBody body
    ) {
        return new RespImpl(
            status,
            statusMsg,
            headers,
            body
        );
    }
}