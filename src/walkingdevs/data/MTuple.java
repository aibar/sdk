package walkingdevs.data;

public class MTuple {
    // Ok, you can pass NULLs
    public static <A, B> Tuple<A, B> mk(A first, B second) {
        return new TupleImpl<A, B>(first, second);
    }
}