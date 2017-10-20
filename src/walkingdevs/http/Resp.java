package walkingdevs.http;

public interface Resp {
    int status();

    String statusMsg();

    Headers headers();

    RespBody body();

    static Resp mk(
        int status,
        String statusMsg,
        Headers headers,
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