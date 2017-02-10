package walkingdevs.vals;

import walkingdevs.val.Val;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class ValsImpl<T> implements Vals<T> {
    public void crash() {
        for (Val val : validators) {
            val.crash();
        }
    }

    public boolean test() {
        for (Val val : validators) {
            if (val.test()) {
                return true;
            }
        }
        return false;
    }

    public T get() {
        crash();
        return val;
    }

    public Vals<T> add(Predicate<T> predicate, String exp) {
        validators.add(Val.mk(
            val,
            name,
            predicate,
            exp
        ));
        return this;
    }

    public Vals<T> cannotBeNULL() {
        validators.add(Val.NULL(
            val,
            name
        ));
        return this;
    }

    ValsImpl(T val, String name) {
        this.val = val;
        this.name = name;
    }

    private final T val;
    private final String name;
    private final List<Val<T>> validators = new ArrayList<>();
}