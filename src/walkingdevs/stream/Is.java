package walkingdevs.stream;

import walkingdevs.Problems;
import walkingdevs.val.Val;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Keeps bytes in memory
// For acceptable small inputs
public interface Is {
    // All bytes at once
    byte[] bytes();

    default boolean isEmpty() {
        return false;
    }

    // Writes fully
    void writeTo(OutputStream os) throws IOException;

    static Is mk(InputStream is) {
        return mk(is, 8192);
    }

    static Is mk(InputStream is, int size) {
        try {
            if (is == null || is.available() < 1) {
                return new IsEmptyImpl();
            }
        } catch (IOException fail) {
            throw Problems.weFucked(fail);
        }
        return new IsImpl(
                is,
                Val.mk(
                        size,
                        "size",
                        () -> size < 1,
                        "Buffer size < 1"
                ).get()
        );
    }
}