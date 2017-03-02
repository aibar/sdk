package walkingdevs.vals;

import walkingdevs.fun.Predicate;
import walkingdevs.val.$Val;
import walkingdevs.val.Val;

import java.util.ArrayList;
import java.util.List;

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

    public T val() {
        return val;
    }

    public String name() {
        return name;
    }

    public Vals<T> add(String exp, Predicate<T> predicate) {
        validators.add($Val.mk(
            name,
            val,
            predicate,
            exp
        ));
        return this;
    }

    public Vals<T> add(Val<T> val) {
        validators.add(val);
        return this;
    }

    public Vals<T> cannotBeNULL() {
        validators.add($Val.NULL(
            name,
            val
        ));
        return this;
    }

    ValsImpl(String name, T val) {
        this.name = name;
        this.val = val;
    }

    private final String name;
    private final T val;
    private final List<Val<T>> validators = new ArrayList<Val<T>>();
}