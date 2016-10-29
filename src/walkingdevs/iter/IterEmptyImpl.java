package walkingdevs.iter;

import java.util.Iterator;

class IterEmptyImpl<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return itor.get();
    }

    private Itor<T> itor = Itor.mk();
}