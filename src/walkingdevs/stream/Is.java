package walkingdevs.stream;

import java.io.IOException;
import java.io.OutputStream;

// Keeps bytes in memory
// For acceptable small inputs
public interface Is {
    // All bytes at once
    byte[] bytes();

    boolean isEmpty();

    // Writes fully
    void writeTo(OutputStream os) throws IOException;
}