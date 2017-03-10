package walkingdevs.http11;

public interface RespNoBody {
    int status();

    String statusMsg();

    Headers headers();

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