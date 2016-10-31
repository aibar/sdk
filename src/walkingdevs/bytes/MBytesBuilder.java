package walkingdevs.bytes;

public class MBytesBuilder {
    public static BytesBuilder mk() {
        return new BytesBuilderImpl();
    }
}