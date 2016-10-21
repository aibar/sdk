package walkingdevs;

import walkingdevs.fun.Handler;

class IterImpl<T> implements Iter<T> {
    public String join(String with) {
        if (with == null) {
            throw new IllegalArgumentException("Argument <String with> is null");
        }
        StringBuilder sb = new StringBuilder();
        list(t -> {
            sb.append(t).append(with);
        });
        return sb.delete(sb.length() - with.length(), sb.length()).toString();
    }

    public void list(Handler<T> handler) {
        for (T t : iterable) {
            handler.handle(t);
        }
    }

    IterImpl(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    private final Iterable<T> iterable;
}