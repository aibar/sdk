package walkingdevs.fun;

public interface Handler<T> {
    void handle(T something);
}