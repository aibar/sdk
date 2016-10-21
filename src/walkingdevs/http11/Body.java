package walkingdevs.http11;

// TODO: not complete
public interface Body {
    byte[] bytes();

    boolean isEmpty();

    static Body mk(byte[] bytes) {
        return new BytesBody(bytes);
    }

    static Body mkEmpty() {
        return mk(new byte[]{});
    }
}