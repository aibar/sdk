package walkingdevs.http11;

public class MRespNoBody {
    static RespNoBody mk(
        int status,
        String statusMsg,
        HttpHeaders headers
    ) {
        return new RespNoBodyImpl(
                status,
                statusMsg,
                headers
        );
    }
}