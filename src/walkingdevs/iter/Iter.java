package walkingdevs.iter;

import walkingdevs.NULLSafe;

import java.util.ArrayList;

public interface Iter<T> extends NULLSafe {
    String join(String with);

    static <T> Iter<T> mk() {
        return mk(new ArrayList<T>());
    }

    static <T> Iter<T> mk(Iterable<T> iterable) {
        if (iterable == null) {
            return mk();
        }
        return new IterImpl<>(iterable);
    }
}