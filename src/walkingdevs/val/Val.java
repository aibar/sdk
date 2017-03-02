package walkingdevs.val;


// Validator
public interface Val<T> {
    void crash();

    boolean test();

    T get();

    // Common
}