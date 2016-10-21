package walkingdevs.stream;

import walkingdevs.bytes.Bytes;
import walkingdevs.Problems;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;

class BufferedIsImpl implements BufferedIs {
    public Bytes bytes() {
        return Bytes.mk(stored.toByteArray());
    }

    public void write(OutputStream os) throws IOException {
        for (byte[] bytes : this) {
            os.write(bytes);
        }
    }

    @Override
    public Iterator<byte[]> iterator() {
        return new BufferedIsIterator();
    }

    @Override
    public void close() throws IOException {
        is.close();
    }

    BufferedIsImpl(InputStream is, int size) {
        this.is = is;
        buffer = new byte[size];
    }

    private final InputStream is;

    private final byte[] buffer;
    private final ByteArrayOutputStream stored = new ByteArrayOutputStream();

    private boolean empty = false;

    private class BufferedIsIterator implements Iterator<byte[]> {
        public boolean hasNext() {
            if (empty && stored.size() > 0) {
                return true;
            }
            try {
                if (is.available() > 0) {
                    return true;
                }
            } catch (IOException fail) {
                throw Problems.weFucked(fail);
            }
            empty = true;
            return false;
        }

        public byte[] next() {
            if (empty) {
                return stored.toByteArray();
            }
            int read;
            try {
                if ((read = is.read(buffer)) != -1) {
                    // Cache bytes
                    stored.write(buffer, 0, read);
                }
            } catch (IOException fail) {
                throw Problems.weFucked(fail);
            }
            if (read != -1) {
                return Arrays.copyOf(buffer, read);
            } else {
                return new byte[0];
            }
        }
    }
}