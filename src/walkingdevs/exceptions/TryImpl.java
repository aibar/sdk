package walkingdevs.exceptions;

class TryImpl<T> implements Try<T> {
    public T Do() {
        try {
            return checked.run();
        } catch (Exception e) {
            throw Exceptions.weFucked(e);
        }
    }

    TryImpl(Checked<T> checked) {
        this.checked = checked;
    }

    private final Checked<T> checked;
}