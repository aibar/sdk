package walkingdevs.str;

import walkingdevs.chset.Chset;
import walkingdevs.chset.MChset;

public class MStr {
    // No NULLs!!!
    public static Str mk() {
        return mk("");
    }

    public static Str mk(String str) {
        if (str == null) {
            return mk();
        }
        return new StrImpl(str);
    }

    // In UTF-8
    public static Str mk(byte[] bytes) {
        return mk(bytes, MChset.UTF8());
    }

    public static Str mk(byte[] bytes, Chset chset) {
        if (bytes == null || bytes.length == 0) {
            return mk();
        } else if(chset == null) {
            return mk(bytes);
        }
        return mk(new String(bytes, chset.get()));
    }
}