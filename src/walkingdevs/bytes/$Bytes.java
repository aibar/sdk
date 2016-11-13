package walkingdevs.bytes;

public class $Bytes {
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