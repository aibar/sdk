package walkingdevs.chset;

import java.nio.charset.Charset;

public interface Chset {
    Charset get();

    String name();
}