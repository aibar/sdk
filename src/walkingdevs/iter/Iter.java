package walkingdevs.iter;

public interface Iter<T> {
    String join(String with);

    static <T> Iter<T> mk() {
        return mk(new IterEmptyImpl<T>());
    }

    static <T> Iter<T> mk(Iterable<T> iterable) {
        if (iterable == null) {
            return mk();
        }
        return new IterImpl<>(iterable);
    }
}