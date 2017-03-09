package walkingdevs.stream;

import walkingdevs.Problems;
import walkingdevs.val.$Val;

import java.io.IOException;
import java.io.InputStream;

public class $BufferedIs {
    public static BufferedIs mk(InputStream is) {
        return mk(is, 8192);
    }

    public static BufferedIs mk(InputStream is, int size) {
        try {
            if (is == null || is.available() < 1) {
                return new BufferedIsEmpty();
            }
        } catch (IOException fail) {
            throw Problems.weFucked(fail);
        }
        return new BufferedIsImpl(
            is,
            $Val.LessThan1("size", size).get()
        );
    }
}