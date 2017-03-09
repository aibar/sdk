package walkingdevs.exceptions;

public interface Try<T> {
    T Do();

    interface Checked<T> {
        T run() throws Exception;
    }
}