package walkingdevs.http11;

public interface Response {
    int status();

    String statusMsg();

    HttpHeaders headers();

    Body body();

    static Response mk(
            int status,
            String statusMsg,
            HttpHeaders headers,
            Body body
    ) {
        return new ResponseImpl(
                status,
                statusMsg,
                headers,
                body
        );
    }
}