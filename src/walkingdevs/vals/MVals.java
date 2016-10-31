package walkingdevs.vals;

import walkingdevs.data.Tuple;
import walkingdevs.fun.Result;
import walkingdevs.val.MVal;
import walkingdevs.val.Val;

import java.util.ArrayList;
import java.util.List;

public class MVals {
    public static <T> Vals<T> mk(T value, String name, Tuple<Result<Boolean>, String>... rps) {
        MVal.mkIsBlank(name, "name").fail();
        List<Val<T>> vals = new ArrayList<Val<T>>();
        for (Tuple<Result<Boolean>, String> rp : rps) {
            MVal.mkIsNull(rp, "rp").fail();
            vals.add(MVal.mk(
                    value,
                    name,
                    rp.first(),
                    String.format(Val.FORMAT, name, value, rp.second())
            ));
        }
        return new ValsImpl<T>(
                value,
                vals
        );
    }
}