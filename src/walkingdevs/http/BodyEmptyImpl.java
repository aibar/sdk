package walkingdevs.http;

import java.io.IOException;
import java.io.OutputStream;

class BodyEmptyImpl implements Body {
    public boolean isEmpty() {
        return true;
    }

    public void writeTo(OutputStream os) throws IOException {
        // Do nothing
    }

    @Override
    public String getString() {
        return null;
    }
}