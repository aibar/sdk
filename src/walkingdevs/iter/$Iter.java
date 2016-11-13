package walkingdevs.iter;

public class $Iter {
    public static <T> Iter<T> mk() {
        return mk(new IterEmptyImpl<T>());
    }

    public static <T> Iter<T> mk(Iterable<T> iterable) {
        if (iterable == null) {
            return mk();
        }
        return new IterImpl<T>(iterable);
    }
}