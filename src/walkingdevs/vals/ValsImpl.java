package walkingdevs.vals;

import walkingdevs.val.Val;

class ValsImpl<T> implements Vals<T> {
    public void fail() {
        for (Val val : validators) {
            val.fail();
        }
    }

    public T get() {
        fail();
        return value;
    }

    ValsImpl(T value, Iterable<Val<T>> validators) {
        this.value = value;
        this.validators = validators;
    }

    private final T value;
    private final Iterable<Val<T>> validators;
}