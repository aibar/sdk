package walkingdevs.data;

public class $Tuple {
    // Ok, you can pass NULLs
    public static <F, S> Tuple<F, S> mk(F first, S second) {
        return new TupleImpl<F, S>(first, second);
    }
}