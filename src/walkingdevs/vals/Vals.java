package walkingdevs.vals;

import walkingdevs.val.Val;

import java.util.function.Predicate;

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

    static StringVals string(String name, String val) {
        return new StringValsImpl(
            mk(name, val)
        );
    }

    static <T> Vals<T> mk(String name, T val) {
        return new ValsImpl<>(
            Val.Blank("name", name).get(),
            val
        );
    }
}