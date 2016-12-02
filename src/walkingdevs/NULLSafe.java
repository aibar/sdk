package walkingdevs;

public interface NULLSafe {
    default boolean isEmpty() {
        return false;
    }
}