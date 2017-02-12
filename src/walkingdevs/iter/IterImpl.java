package walkingdevs.iter;

import walkingdevs.val.Val;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class IterImpl<T> implements Iter<T> {
    public String join(String with) {
        Val.NULL("with", with).crash();
        StringBuilder sb = new StringBuilder();
        for (T t : iterable) {
            sb.append(t).append(with);
        }
        if (sb.length() < 1) {
            return "";
        }
        return sb.delete(
            sb.length() - with.length(),
            sb.length()
        ).toString();
    }

    public int size() {
        return indexedCash().size();
    }

    public boolean isEmpty() {
        return !iterable.iterator().hasNext();
    }

    @Override
    public Iterator<T> iterator() {
        return iterable.iterator();
    }

    @Override
    public int hashCode() {
        return iterable.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Iter)) {
            return false;
        }
        Iter<T> other = (Iter<T>) object;
        if (other.size() != size()) {
            return false;
        }
        int i = 0;
        for (T t : other) {
            if (t == null && indexedCash().get(i) != null) {
                return false;
            } else if(t != null && !t.equals(indexedCash().get(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    IterImpl(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    private final Iterable<T> iterable;
    private List<T> indexedCash;

    private List<T> indexedCash() {
        if (indexedCash == null) {
            indexedCash = new ArrayList<>();
            for (T t : iterable) {
                indexedCash.add(t);
            }
        }
        return indexedCash;
    }
}