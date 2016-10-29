package walkingdevs.http11;

import walkingdevs.chset.Chset;

// For acceptable small inputs
public interface RespBody {
    byte[] get();

    int length();

    boolean isEmpty();

    // In UTF-8
    String text();

    String text(Chset chset);

    static RespBody mk() {
        return mk(new byte[0]);
    }

    static RespBody mk(byte[] bytes) {
        if (bytes == null) {
            return mk();
        }
        return new RespBodyImpl(bytes);
    }
}