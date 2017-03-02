package walkingdevs.exceptions;

import walkingdevs.val.$Val;

/**
 * Created by olzhas on 28.02.17.
 */
public class $Try {
    public static <T> Try<T> mk(Try.Checked<T> checked) {
        return new TryImpl(
                $Val.NULL("checked", checked).get()
        );
    }
}
