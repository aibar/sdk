package walkingdevs.stream;

import walkingdevs.Problems;
import walkingdevs.val.mVal;

import java.io.IOException;
import java.io.InputStream;

// Keeps bytes in memory
// For acceptable small inputs
public class mIs {
    public static Is mk(InputStream is) {
        return mk(is, 8192);
    }

    public static Is mk(InputStream is, int size) {
        try {
            if (is == null || is.available() < 1) {
                return new IsEmptyImpl();
            }
        } catch (IOException fail) {
            throw Problems.weFucked(fail);
        }
        return new IsImpl(
            is,
            mVal.isLessThan1(size, "size").get()
        );
    }
}