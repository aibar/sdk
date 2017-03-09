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
        System.out.println(status);
        System.out.println(statusMsg);
        System.out.println(headers);
        return new RespNoBodyImpl(
            status,
            statusMsg,
            headers
        );
    }
}