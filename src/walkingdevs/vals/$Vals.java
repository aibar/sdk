package walkingdevs.vals;

import walkingdevs.val.$Val;
import walkingdevs.val.Val;

public class $Vals {
    public static StringVals string(String name, String val) {
        return new StringValsImpl(
                mk(name, val)
        );
    }

    public static <T> Vals<T> mk(String name, T val) {
        return new ValsImpl<T>(
                $Val.Blank("name", name).get(),
                val
        );
    }
}