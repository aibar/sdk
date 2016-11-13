package walkingdevs.iter;

import walkingdevs.val.$Val;

class IterImpl<T> implements Iter<T> {
    public String join(String with) {
        $Val.isIsNull(with, "with").fail();
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

    IterImpl(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    private final Iterable<T> iterable;
}