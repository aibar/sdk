package walkingdevs.bytes;

import walkingdevs.Charsets;

public interface Bytes extends Iterable<Byte> {
    byte[] copy();

    int length();

    // UTF-8
    String text();

    String text(Charsets charset);

    static Bytes mk(byte[] bytes) {
        return new BytesImpl(bytes);
    }
}