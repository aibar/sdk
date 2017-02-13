package walkingdevs.exceptions;

public interface Checked<T> {
    T run() throws Exception;
}