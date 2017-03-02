package walkingdevs.iter;

public interface Iter<T> extends Iterable<T> {
    String join(String with);

    int size();
}