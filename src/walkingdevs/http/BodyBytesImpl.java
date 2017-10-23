package walkingdevs.http;

import java.io.IOException;
import java.io.OutputStream;

class BodyBytesImpl implements Body {
    public void writeTo(OutputStream os) throws IOException {
        os.write(bytes);
    }

    public String getString() {
        return null;
    }

    BodyBytesImpl(byte[] bytes) {
        this.bytes = bytes;
    }

    private final byte[] bytes;
}