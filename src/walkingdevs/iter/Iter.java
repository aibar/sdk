package walkingdevs.iter;

import walkingdevs.NULLSafe;

public interface Iter<T> extends Iterable<T>, NULLSafe {
    String join(String with);
}