package walkingdevs.bytes;

import walkingdevs.Charsets;
import walkingdevs.Iter;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

class BytesImpl implements Bytes {
    public byte[] copy() {
        byte[] copy = new byte[length()];
        System.arraycopy(bytes, 0, copy, 0, bytes.length);
        return copy;
    }

    public int length() {
        return bytes.length;
    }

    public String text() {
        return new String(bytes, Charset.forName("UTF-8"));
    }

    public String text(Charsets charset) {
        return new String(bytes, Charset.forName(charset.toString()));
    }

    @Override
    public Iterator<Byte> iterator() {
        return new BytesIterator();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(copy());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Bytes)) {
            return false;
        }

        Bytes other = (Bytes) object;
        if (other.length() != length()) {
            return false;
        }

        byte[] otherBytes = other.copy();
        for (int i = 0; i < otherBytes.length; i++) {
            if (otherBytes[i] != copy()[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return Iter.mk(this).join(", ");
    }

    BytesImpl(byte[] bytes) {
        this.bytes = bytes;
    }

    private final byte[] bytes;

    private class BytesIterator implements Iterator<Byte> {
        public boolean hasNext() {
            return i < length();
        }

        public Byte next() {
            return copy()[i++];
        }

        private int i = 0;
    }
}