package walkingdevs.stream;

import walkingdevs.val.$Val;

import java.io.InputStream;

public class $BufferedIs {
    public static BufferedIs mk() {
        return new BufferedIsEmpty();
    }

    public static BufferedIs mk(InputStream is) {
        return mk(is, 8192);
    }

    public static BufferedIs mk(InputStream is, int size) {
        if (is == null) {
            return mk();
        }
        return new BufferedIsImpl(
            is,
            $Val.LessThan1("size", size).get()
        );
    }
}