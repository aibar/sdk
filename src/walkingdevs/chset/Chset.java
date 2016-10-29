package walkingdevs.chset;

import java.nio.charset.Charset;

public interface Chset {
    Charset get();

    String name();

    static Chset Default() {
        return new ChsetImpl(Charset.defaultCharset().name());
    }

    static Chset UTF8() {
        return new ChsetImpl("UTF-8");
    }

    static Chset KOI8R() {
        return new ChsetImpl("KOI8-R");
    }
}