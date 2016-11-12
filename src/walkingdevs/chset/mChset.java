package walkingdevs.chset;

import java.nio.charset.Charset;

public class mChset {
    public static Chset Default() {
        return new ChsetImpl(Charset.defaultCharset().name());
    }

    public static Chset UTF8() {
        return new ChsetImpl("UTF-8");
    }

    public static Chset KOI8R() {
        return new ChsetImpl("KOI8-R");
    }
}