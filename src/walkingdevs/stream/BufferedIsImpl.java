package walkingdevs.stream;

import walkingdevs.exceptions.$Try;
import walkingdevs.exceptions.Try;
import walkingdevs.val.$Val;
import walkingdevs.val.Val;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;

class BufferedIsImpl implements BufferedIs {
    public boolean isEmpty() {
        return next == null;
    }

    public void writeTo(OutputStream os) throws IOException {
        $Val.NULL("os", os).crash();
        for (byte[] bytes : this) {
            os.write(bytes);
        }
    }

    @Override
    public Iterator<byte[]> iterator() {
        return new Iterator<byte[]>() {
            public boolean hasNext() {
                return next != null || read() != null;
            }
            public byte[] next() {
                byte[] nextRef = next;
                next = null;
                return nextRef;
            }

            public void remove() {
            }
        };
    }

    BufferedIsImpl(InputStream is, int size) {
        this.is = is;
        this.buffer = new byte[size];

        // Hack, because InputStream.available() doesn't works as expected and should
        read();
    }

    private final InputStream is;
    private final byte[] buffer;
    private byte[] next;

    private byte[] read() {
        next = null;
        int read = $Try.mk(() -> is.read(buffer)).Do();
        if (read > 0) {
            next = Arrays.copyOf(buffer, read);
        }
        return next;
    }
}