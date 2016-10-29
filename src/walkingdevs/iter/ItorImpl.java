package walkingdevs.iter;

import java.util.Iterator;

class ItorImpl<T> implements Itor<T> {
    public Iterator<T> get() {
        return iterator;
    }

    ItorImpl(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    private final Iterator<T> iterator;
}