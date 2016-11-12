package walkingdevs.stream;

import walkingdevs.Problems;
import walkingdevs.val.Val;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// For "Big Data"
public interface BufferedIs extends Iterable<byte[]> {
    boolean isEmpty();

    // Writes all remained bytes
    void writeTo(OutputStream os) throws IOException;

    static BufferedIs mk(InputStream is) {
        return mk(is, 8192);
    }

    static BufferedIs mk(InputStream is, int size) {
        try {
            if (is == null || is.available() < 1) {
                return new BufferedIsEmptyImpl();
            }
        } catch (IOException fail) {
            throw Problems.weFucked(fail);
        }
        return new BufferedIsImpl(
            is,
            Val.isLessThan1(size, "size").get()
        );
    }
}