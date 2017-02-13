package walkingdevs.stream;

import walkingdevs.val.Val;

import java.io.IOException;
import java.io.OutputStream;

class IsImpl implements Is {
    public byte[] bytes() {
        return bytes;
    }

    public boolean isEmpty() {
        return bytes.length == 0;
    }

    public void writeTo(OutputStream os) throws IOException {
        Val.NULL("os", os)
            .get()
            .write(bytes);
    }

    IsImpl(byte[] bytes) {
        this.bytes = bytes;
    }

    private final byte[] bytes;
}