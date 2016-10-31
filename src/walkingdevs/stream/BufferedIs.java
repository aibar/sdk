package walkingdevs.stream;

import java.io.IOException;
import java.io.OutputStream;

// For "Big Data"
public interface BufferedIs extends Iterable<byte[]> {
    boolean isEmpty();

    // Writes all remained bytes
    void writeTo(OutputStream os) throws IOException;
}