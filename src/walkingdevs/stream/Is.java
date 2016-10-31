package walkingdevs.stream;

// Keeps bytes in memory
// For acceptable small inputs
public interface Is {
    // All bytes at once
    byte[] bytes();

    boolean isEmpty();
}