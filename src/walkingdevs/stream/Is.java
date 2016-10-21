package walkingdevs.stream;

import walkingdevs.Val;
import walkingdevs.bytes.Bytes;

import java.io.InputStream;

public interface Is extends Iterable<Byte>, AutoCloseable {
    Bytes bytes();

    static Is mk(InputStream is) {
        return new IsImpl(
                Val.isNull(is, "is").getOrFail()
        );
    }
}