package walkingdevs.iter;

import java.util.Iterator;

class ItorEmptyImpl<T> implements Itor<T> {
    public Iterator<T> get() {
        return new Iterator<T>() {
            public boolean hasNext() {
                return false;
            }
            public T next() {
                return null;
            }
            public void remove() {
            }
        };
    }
}