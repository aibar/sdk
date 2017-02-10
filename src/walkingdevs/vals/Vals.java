package walkingdevs.vals;

import walkingdevs.data.Tuple;
import walkingdevs.val.Val;

import java.util.function.Predicate;

// Vals = Validators
public interface Vals<T> {
    void crash();

    boolean test();

    T get();

    Vals<T> add(Predicate<T> predicate, String exp);

    Vals<T> cannotBeNULL();

    static <T> Vals<T> mk(T val, String name, Tuple<Predicate<T>, String>... predicateExps) {
        Val.Blank(name, "name").crash();
        Vals<T> vals = new ValsImpl<>(val, name);
        for (Tuple<Predicate<T>, String> predicateExp : predicateExps) {
            Val.NULL(predicateExp, "predicateExp").crash();
            vals.add(
                predicateExp.first(),
                predicateExp.second()
            );
        }
        return vals;
    }
}