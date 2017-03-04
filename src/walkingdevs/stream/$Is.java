package walkingdevs.stream;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;

// Keeps bytes in memory
// For acceptable small inputs
public class $Is {
    public static Is mk() {
        return new IsEmpty();
    }

    public static Is mk(InputStream is) {
        return mk(is, 8192);
    }

    public static Is mk(InputStream is, int size) {
        if (is == null) {
            return mk();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
        for (byte[] buffer : $BufferedIs.mk(is, size)) {
            baos.write(buffer, 0, buffer.length);
        }
        return new IsImpl(baos.toByteArray());
    }
}