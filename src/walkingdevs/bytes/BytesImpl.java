package walkingdevs.bytes;

import java.util.Arrays;

class BytesImpl implements Bytes {
    public byte[] get() {
        return bytes;
    }

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
        if (other.length() != length()) {
            return false;
        }
        byte[] otherBytes = other.get();
        for (int i = 0; i < otherBytes.length; i++) {
            if (otherBytes[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        int to = 10;
        if (length() < 10) {
            to = length();
        }
        String string = "";
        for (int i = 0; i < to-1; i++) {
            string += bytes[i] + ", ";
        }
        return string + bytes[to-1];
    }

    BytesImpl(byte[] bytes) {
        this.bytes = bytes;
    }

    private final byte[] bytes;
}