package walkingdevs.iter;

import java.util.Iterator;

class ItorImpl<T> implements Itor<T> {
    public Iterator<T> get() {
        return new Iterator<T>() {
            @Override
            public void remove() {
                //TODO:
            }
            public boolean hasNext() {
                return i < array.length;
            }
            public T next() {
                return array[i++];
            }
            private int i = 0;
        };
    }

    ItorImpl(T[] array) {
        this.array = array;
    }

    private final T[] array;
}