package walkingdevs.vals;

import walkingdevs.fun.Result;
import walkingdevs.data.Tuple;
import walkingdevs.val.Val;

import java.util.ArrayList;
import java.util.List;

public interface Vals<T> {
    void fail();

    T get();

    static <T> Vals<T> mk(T value, String name, Tuple<Result<Boolean>, String>... rps) {
        Val.isBlank(name, "name").fail();
        List<Val<T>> vals = new ArrayList<>();
        for (Tuple<Result<Boolean>, String> rp : rps) {
            Val.isNull(rp, "rp").fail();
            vals.add(Val.mk(
                value,
                name,
                rp.first(),
                String.format(Val.FORMAT, name, value, rp.second())
            ));
        }
        return new ValsImpl<>(
            value,
            vals
        );
    }
}