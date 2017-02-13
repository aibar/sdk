package walkingdevs.iter;

import java.util.ArrayList;

public interface Iter<T> extends Iterable<T> {
    String join(String with);

    int size();

    static <T> Iter<T> mk(Iterable<T> iterable) {
        if (iterable == null) {
            return mk();
        }
        return new IterImpl<>(iterable);
    }

    static <T> Iter<T> mk() {
        return mk(new ArrayList<T>());
    }

    static <T> Iter<T> mk(T... array) {
        ArrayList<T> iterable = new ArrayList<>();
        for (T t : array) {
            iterable.add(t);
        }
        return mk(iterable);
    }
}