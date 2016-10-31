package walkingdevs.http11;

import java.io.IOException;
import java.io.OutputStream;

// Req body
public interface Body {
    // Otherwise it doesn't make sense
    boolean isEmpty();

    void writeTo(OutputStream os) throws IOException;
}