package walkingdevs.bytes;

import java.util.Arrays;

class BytesImpl implements Bytes {
    public byte[] copy() {
        return Arrays.copyOf(bytes, length());
    }

    public int length() {
        return bytes.length;
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Bytes)) {
            return false;
        }

        Bytes other = (Bytes) object;
        if (other.length() != bytes.length) {
            return false;
        }

        byte[] otherBytes = other.copy();
        for (int i = 0; i < otherBytes.length; i++) {
            if (otherBytes[i] != bytes[i]) {
                return false;
            }
        }

        return true;
    }

    // TODO: print first 10 bytes
    @Override
    public String toString() {
        return super.toString() + " length=" + length();
    }

    BytesImpl(byte[] bytes) {
        this.bytes = bytes;
    }

    private final byte[] bytes;
}