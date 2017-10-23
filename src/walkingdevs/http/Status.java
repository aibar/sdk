package walkingdevs.http;

import java.io.InputStream;

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
        return mk(200, "OK");
    }

    static Status parseFromRequest(InputStream is) {
        return null;
    }
}