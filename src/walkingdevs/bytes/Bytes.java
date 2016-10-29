package walkingdevs.bytes;

public interface Bytes {
    // Copy
    byte[] get();

    int length();

    boolean isEmpty();

    static Bytes mk() {
        return mk(new byte[0]);
    }

    static Bytes mk(byte[] bytes) {
        if (bytes == null) {
            return mk();
        }
        return new BytesImpl(bytes);
    }
}