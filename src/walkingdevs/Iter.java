package walkingdevs;

import walkingdevs.fun.Handler;

public interface Iter<T> {
    String join(String with);

    void list(Handler<T> handler);

    static <T> Iter<T> mk(Iterable<T> iterable) {
        return new IterImpl<>(iterable);
    }
}