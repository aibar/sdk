package walkingdevs.bytes;

public class mBytes {
    public static Bytes mk() {
        return mk(new byte[0]);
    }

    public static Bytes mk(byte[] bytes) {
        if (bytes == null) {
            return mk();
        }
        return new BytesImpl(bytes);
    }
}