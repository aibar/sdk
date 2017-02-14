package walkingdevs.iter;

import java.util.Iterator;

class ItorEmpty<T> implements Itor<T> {
    public Iterator<T> get() {
        return new Iterator<T>() {
            public boolean hasNext() {
                return false;
            }
            public T next() {
                return null;
            }
        };
    }
}