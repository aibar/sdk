package walkingdevs;

class ValsImpl<T> implements Vals<T> {
    public void fail() {
        for (Val val : validators) {
            val.fail();
        }
    }

    public T getOrFail() {
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