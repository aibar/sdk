package walkingdevs.stream;

import walkingdevs.exceptions.Exceptions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;

class BufferedIsImpl implements BufferedIs {
    public boolean isEmpty() {
        return empty;
    }

    public void writeTo(OutputStream os) throws IOException {
        for (byte[] bytes : this) {
            os.write(bytes);
        }
    }

    @Override
    public Iterator<byte[]> iterator() {
        return new Iterator<byte[]>() {
            public boolean hasNext() {
                return !isEmpty();
            }

            public byte[] next() {
                int read;
                byte[] buffer = new byte[size];
                try {
                    read = is.read(buffer);
                } catch (IOException fail) {
                    throw Exceptions.weFucked(fail);
                }
                if (read > 0) {
                    return Arrays.copyOf(buffer, read);
                } else {
                    empty = true;
                    return new byte[0];
                }
            }
        };
    }

    BufferedIsImpl(InputStream is, int size) {
        this.is = is;
        this.size = size;
    }

    private final InputStream is;
    private final int size;

    private boolean empty = false;
}