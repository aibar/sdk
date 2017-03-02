package walkingdevs.vals;

import walkingdevs.fun.Predicate;
import walkingdevs.val.Val;

// Vals = Validators
public interface Vals<T> {
    void crash();

    // Tests for Invalid
    boolean test();

    // Try to crash and return val
    T get();
    // Return val without tests
    T val();

    String name();

    Vals<T> add(String exp, Predicate<T> predicate);

    Vals<T> add(Val<T> val);

    Vals<T> cannotBeNULL();
}