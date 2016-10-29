package walkingdevs.iter;

import java.util.Iterator;

public interface Itor<T> {
    Iterator<T> get();

    static <T> Itor<T> mk() {
        return new ItorEmptyImpl<>();
    }

    static <T> Itor<T> mk(Iterator<T> iterator) {
        if (iterator == null) {
            return mk();
        }
        return new ItorImpl<>(iterator);
    }
}