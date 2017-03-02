package walkingdevs.bytes;

public class $BytesBuilder {
    public static BytesBuilder mk(byte[] bytes) {
        return mk().add(bytes);
    }

    public static BytesBuilder mk() {
        return new BytesBuilderImpl();
    }
}