package walkingdevs.data;

public interface Tuple<F, S> {
    F first();
    S second();

    // Ok, you can pass NULLs
}