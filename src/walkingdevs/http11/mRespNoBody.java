package walkingdevs.http11;

public class mRespNoBody {
    static RespNoBody mk(
        int status,
        String statusMsg,
        Headers headers
    ) {
        return new RespNoBodyImpl(
            status,
            statusMsg,
            headers
        );
    }
}