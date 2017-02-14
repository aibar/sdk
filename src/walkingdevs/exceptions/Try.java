package walkingdevs.exceptions;

import walkingdevs.val.Val;

public interface Try<T> {
    T Do();

    static <T> Try<T> mk(Checked<T> checked) {
        return new TryImpl(
            Val.NULL("checked", checked).get()
        );
    }

    interface Checked<T> {
        T run() throws Exception;
    }
}