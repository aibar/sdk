package walkingdevs.http11;

import walkingdevs.bytes.mBytes;
import walkingdevs.chset.Chset;
import walkingdevs.chset.mChset;
import walkingdevs.str.mStr;
import walkingdevs.stream.BufferedIs;
import walkingdevs.stream.mBufferedIs;

import java.io.InputStream;

public class mBody {
    public static Body mk() {
        return new BodyEmptyImpl();
    }

    public static Body mk(HttpForm form) {
        return mk(form.get());
    }

    public static Body mk(String text) {
        return mk(text, mChset.UTF8());
    }

    public static Body mk(String text, Chset chset) {
        if (mStr.mk(text).isEmpty()) {
            return mk();
        }
        return mk(mStr.mk(text).bytes(chset));
    }

    public static Body mk(byte[] bytes) {
        if (mBytes.mk(bytes).isEmpty()) {
            return mk();
        }
        return new BodyBytesImpl(bytes);
    }

    public static Body mk(InputStream inputStream) {
        return mk(inputStream, 8192);
    }

    public static Body mk(InputStream is, int size) {
        BufferedIs bufferedIs = mBufferedIs.mk(is, size);
        if (bufferedIs.isEmpty()) {
            return mk();
        }
        return new BodyBufferedIsImpl(bufferedIs);
    }
}