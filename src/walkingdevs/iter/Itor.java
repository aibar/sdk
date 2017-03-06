package walkingdevs.iter;

import java.util.Iterator;

public interface Itor<T> {
    Iterator<T> get();

    static <T> Itor<T> mk() {
        return new ItorEmpty<>();
    }

    static <T> Itor<T> mk(T... array) {
        return mkFromArray(array);
    }

    static <T> Itor<T> mkFromArray(T[] array) {
        if (array == null) {
            return mk();
        }
        return new ItorImpl<>(array);
    }
}