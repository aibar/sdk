package walkingdevs.http;

import walkingdevs.bytes.Bytes;
import walkingdevs.chset.Chset;
import walkingdevs.str.Str;
import walkingdevs.stream.BufferedIs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Req body
public interface Body {
    String string();

    // Otherwise it doesn't make sense
    default boolean isEmpty() {
        return false;
    }

    void writeTo(OutputStream os) throws IOException;

    static Body mk() {
        return new BodyEmptyImpl();
    }

    // Assume it's UTF-8...
    static Body mk(Form form) {
        return mk(form.get());
    }

    // Default to UTF-8
    static Body mk(String text) {
        return mk(text, Chset.UTF8());
    }

    static Body mk(String text, Chset chset) {
        if (Str.mk(text).isEmpty()) {
            return mk();
        }
        return mk(Str.mk(text).bytes(chset));
    }

    static Body mk(byte[] bytes) {
        if (Bytes.mk(bytes).isEmpty()) {
            return mk();
        }
        return new BodyBytesImpl(bytes);
    }

    static Body mk(InputStream inputStream) {
        return mk(inputStream, 8192);
    }

    static Body mk(InputStream is, int size) {
        BufferedIs bufferedIs = BufferedIs.mk(is, size);
        if (bufferedIs.isEmpty()) {
            return mk();
        }
        return new BodyBufferedIsImpl(bufferedIs);
    }
}