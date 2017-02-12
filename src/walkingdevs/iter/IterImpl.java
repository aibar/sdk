package walkingdevs.iter;

import walkingdevs.val.Val;

import java.util.Iterator;

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

    public boolean isEmpty() {
        return !iterable.iterator().hasNext();
    }

    @Override
    public Iterator<T> iterator() {
        return iterable.iterator();
    }

    IterImpl(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    private final Iterable<T> iterable;
}