package walkingdevs.http11;

public class $RespNoBody {
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