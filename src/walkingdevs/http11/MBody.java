package walkingdevs.http11;

import walkingdevs.bytes.MBytes;
import walkingdevs.chset.Chset;
import walkingdevs.chset.MChset;
import walkingdevs.str.MStr;
import walkingdevs.stream.BufferedIs;
import walkingdevs.stream.MBufferedIs;

import java.io.InputStream;

public class MBody {
    public static Body mk() {
        return new BodyEmptyImpl();
    }

    public static Body mk(HttpForm form) {
        return mk(form.get());
    }

    public static Body mk(String text) {
        return mk(text, MChset.UTF8());
    }

    public static Body mk(String text, Chset chset) {
        if (MStr.mk(text).isEmpty()) {
            return mk();
        }
        return mk(MStr.mk(text).bytes(chset));
    }

    public static Body mk(byte[] bytes) {
        if (MBytes.mk(bytes).isEmpty()) {
            return mk();
        }
        return new BodyBytesImpl(bytes);
    }

    public static Body mk(InputStream inputStream) {
        return mk(inputStream, 8192);
    }

    public static Body mk(InputStream is, int size) {
        BufferedIs bufferedIs = MBufferedIs.mk(is, size);
        if (bufferedIs.isEmpty()) {
            return mk();
        }
        return new BodyBufferedIsImpl(bufferedIs);
    }
}