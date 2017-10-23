package walkingdevs.http;

import java.io.IOException;
import java.io.OutputStream;

class BodyEmptyImpl implements Body {
    public String string() {
        return "";
    }

    public boolean isEmpty() {
        return true;
    }

    public void writeTo(OutputStream os) throws IOException {
        // Do nothing
    }
}