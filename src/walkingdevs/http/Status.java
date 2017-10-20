package walkingdevs.http;

public interface Status {
    int code();

    String message();

    static Status mk(int code, String message) {
        return new StatusImpl(
            code,
            message
        );
    }

    static Status ok() {
        return null;
    }
}