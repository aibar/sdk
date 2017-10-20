package walkingdevs.http;

import walkingdevs.stream.BufferedIs;

import java.io.IOException;
import java.io.OutputStream;

class BodyBufferedIsImpl implements Body {
    public void writeTo(OutputStream os) throws IOException {
        for (byte[] bytes : bufferedIs) {
            os.write(bytes);
        }
    }

    BodyBufferedIsImpl(BufferedIs bufferedIs) {
        this.bufferedIs = bufferedIs;
    }

    private final BufferedIs bufferedIs;
}