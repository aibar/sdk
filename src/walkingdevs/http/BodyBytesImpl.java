package walkingdevs.http;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

class BodyBytesImpl implements Body {
    public void writeTo(OutputStream os) throws IOException {
        os.write(bytes);
    }

    public String getString() {
        return new String(bytes, StandardCharsets.UTF_8);
    }

    BodyBytesImpl(byte[] bytes) {
        this.bytes = bytes;
    }

    private final byte[] bytes;
}