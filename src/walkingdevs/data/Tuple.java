package walkingdevs.data;

public interface Tuple<A, B> {
    A first();

    B second();

    // Ok, you can pass NULLs
    static <A, B> Tuple<A, B> mk(A first, B second) {
        return new TupleImpl<>(first, second);
    }
}