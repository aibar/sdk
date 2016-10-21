package walkingdevs.http11;

class BytesBody implements Body {
    public byte[] bytes() {
        return bytes;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    BytesBody(byte[] bytes) {
        this.bytes = bytes;
    }

    private final byte[] bytes;
}