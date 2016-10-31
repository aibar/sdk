package walkingdevs.stream;

import walkingdevs.val.MVal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class IsImpl implements Is {
    public byte[] bytes() {
        return bytes;
    }

    public boolean isEmpty() {
        return false;
    }

    public void writeTo(OutputStream os) throws IOException {
        MVal.mkIsNull(os, "os").get().write(bytes);
    }

    IsImpl(InputStream is, int size) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
        for (byte[] buffer : MBufferedIs.mk(is, size)) {
            baos.write(buffer, 0, buffer.length);
        }
        bytes = baos.toByteArray();
    }

    private final byte[] bytes;
}