package walkingdevs.stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Keeps bytes in memory
// For acceptable small inputs
public interface Is {
    // All bytes at once
    byte[] bytes();

    boolean isEmpty();

    // Writes fully
    void writeTo(OutputStream os) throws IOException;

    static Is mk() {
        return new IsEmpty();
    }

    static Is mk(InputStream is) {
        return mk(is, 8192);
    }

    static Is mk(InputStream is, int size) {
        if (is == null) {
            return mk();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
        for (byte[] buffer : BufferedIs.mk(is, size)) {
            baos.write(buffer, 0, buffer.length);
        }
        return new IsImpl(baos.toByteArray());
    }
}