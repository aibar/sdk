package walkingdevs.data;

public interface Tuple<F, S> {
    F first();

    S second();

    // Ok, you can pass NULLs
    static <F, S> Tuple<F, S> mk(F first, S second) {
        return new TupleImpl<>(first, second);
    }
}