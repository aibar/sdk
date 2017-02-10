package walkingdevs.val;

import java.util.function.Predicate;

class ValImpl<T> implements Val<T> {
    public void crash() {
        if (predicate.test(val)) {
            throw toThrow;
        }
    }

    public boolean test() {
        return predicate.test(val);
    }

    public T get() {
        crash();
        return val;
    }

    ValImpl(T val, Predicate<T> predicate, RuntimeException toThrow) {
        this.val = val;
        this.predicate = predicate;
        this.toThrow = toThrow;
    }

    private final T val;
    private final Predicate<T> predicate;
    private final RuntimeException toThrow;
}