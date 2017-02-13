package walkingdevs.stream;

import walkingdevs.val.Val;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Doesn't keeps bytes, read once and forget
// For "Big Data"
public interface BufferedIs extends Iterable<byte[]> {
    boolean isEmpty();

    // Writes all remained bytes
    void writeTo(OutputStream os) throws IOException;

    static BufferedIs mk() {
        return new BufferedIsEmpty();
    }

    static BufferedIs mk(InputStream is) {
        return mk(is, 8192);
    }

    static BufferedIs mk(InputStream is, int size) {
        if (is == null) {
            return mk();
        }
        return new BufferedIsImpl(
            is,
            Val.LessThan1("size", size).get()
        );
    }
}