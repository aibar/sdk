package walkingdevs.http11;

public class MResp {
    public static Resp mk(
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