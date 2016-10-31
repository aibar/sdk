package walkingdevs.val;

import walkingdevs.Problems;
import walkingdevs.fun.Result;
import walkingdevs.str.MStr;

import static walkingdevs.val.Val.BANG;
import static walkingdevs.val.Val.BLANK;
import static walkingdevs.val.Val.FORMAT;

public class MVal {
    public static Val<Integer> mkNegative(final Integer value, String name) {
        return mk(
            value,
            name,
            new Result<Boolean>() {
                public Boolean get() {
                    return value < 0;
                }
            },
            String.format(FORMAT, name, value, "Cannot be negative")
        );
    }

    public static Val<Integer> mkLessThan1(final Integer value, String name) {
        return mk(
            value,
            name,
            new Result<Boolean>() {
                public Boolean get() {
                    return value < 1;
                }
            },
            String.format(FORMAT, name, value, "Cannot be < 1")
        );
    }

    public static <T> Val<T> mkIsNull(final T value, String name) {
        return mk(
            value,
            name,
            new Result<Boolean>() {
                public Boolean get() {
                    return value == null;
                }
            },
            BANG
        );
    }

    public static Val<String> mkIsBlank(final String value, String name) {
        return mk(
            value,
            name,
            new Result<Boolean>() {
                public Boolean get() {
                    return MStr.mk(value).isBlank();
                }
            },
            BLANK
        );
    }

    public static <T> Val<T> mk(T value, String name, Result<Boolean> result, String problem) {
        if (MStr.mk(name).isBlank()) {
            throw Problems.illegalArg(
                String.format(FORMAT, "name", name, BLANK)
            );
        }
        if (MStr.mk(problem).isBlank()) {
            throw Problems.illegalArg(
                String.format(FORMAT, "problem", problem, BLANK)
            );
        }
        return new ValImpl<T>(value, name, result, problem);
    }
}