package walkingdevs.bytes;

public interface BytesBuilder {
    byte[] get();

    int length();

    boolean isEmpty();

    BytesBuilder add(byte[] bytes);

    static BytesBuilder mk() {
        return new BytesBuilderImpl();
    }
}