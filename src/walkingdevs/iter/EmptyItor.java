package walkingdevs.iter;

import java.util.Iterator;

class EmptyItor<T> implements Itor<T> {
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