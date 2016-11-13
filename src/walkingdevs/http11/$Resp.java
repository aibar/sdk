package walkingdevs.http11;

public class $Resp {
    public static Resp mk(
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