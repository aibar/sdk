package walkingdevs.http11;

import walkingdevs.bytes.$Bytes;
import walkingdevs.chset.Chset;
import walkingdevs.chset.$Chset;
import walkingdevs.str.$Str;
import walkingdevs.stream.BufferedIs;
import walkingdevs.stream.$BufferedIs;

import java.io.InputStream;

public class $Body {
    public static Body mk() {
        return new BodyEmptyImpl();
    }

    public static Body mk(Form form) {
        return mk(form.get());
    }

    public static Body mk(String text) {
        return mk(text, $Chset.UTF8());
    }

    public static Body mk(String text, Chset chset) {
        if ($Str.mk(text).isEmpty()) {
            return mk();
        }
        return mk($Str.mk(text).bytes(chset));
    }

    public static Body mk(byte[] bytes) {
        if ($Bytes.mk(bytes).isEmpty()) {
            return mk();
        }
        return new BodyBytesImpl(bytes);
    }

    public static Body mk(InputStream inputStream) {
        return mk(inputStream, 8192);
    }

    public static Body mk(InputStream is, int size) {
        BufferedIs bufferedIs = $BufferedIs.mk(is, size);
        if (bufferedIs.isEmpty()) {
            return mk();
        }
        return new BodyBufferedIsImpl(bufferedIs);
    }
}