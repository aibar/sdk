package walkingdevs.bytes;

public interface Bytes {
    byte[] get();

    byte[] copy();

    int length();

    boolean isEmpty();
}