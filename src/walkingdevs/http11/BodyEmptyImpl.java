package walkingdevs.http11;

import java.io.IOException;
import java.io.OutputStream;

class BodyEmptyImpl implements Body {
    public boolean isEmpty() {
        return true;
    }

    public void writeTo(OutputStream os) throws IOException {
        // Do nothing
    }
}