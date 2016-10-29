package walkingdevs.http11;

public interface RespNoBody {
    int status();

    String statusMsg();

    HttpHeaders headers();

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