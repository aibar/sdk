package walkingdevs.http;

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