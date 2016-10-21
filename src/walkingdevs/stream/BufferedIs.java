package walkingdevs.stream;

import walkingdevs.Val;
import walkingdevs.bytes.Bytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface BufferedIs extends Iterable<byte[]>, AutoCloseable {
    // Cached bytes
    Bytes bytes();

    // Writes fully
    void write(OutputStream os) throws IOException;

    static BufferedIs mk(InputStream is, int size) {
        return new BufferedIsImpl(
                Val.isNull(is, "is").getOrFail(),
                Val.mk(size, "size", size < 1, "Buffer size is less than 1").getOrFail()
        );
    }
}