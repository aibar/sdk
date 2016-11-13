package walkingdevs.val;

import walkingdevs.Problems;
import walkingdevs.fun.Result;
import walkingdevs.str.$Str;

import static walkingdevs.val.Val.BANG;
import static walkingdevs.val.Val.BLANK;
import static walkingdevs.val.Val.FORMAT;

public class $Val {
    public static Val<Integer> isNegative(final Integer value, String name) {
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

    public static Val<Integer> isLessThan1(final Integer value, String name) {
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

    public static <T> Val<T> isIsNull(final T value, String name) {
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

    public static Val<String> isIsBlank(final String value, String name) {
        return mk(
            value,
            name,
            new Result<Boolean>() {
                public Boolean get() {
                    return $Str.mk(value).isBlank();
                }
            },
            BLANK
        );
    }

    public static <T> Val<T> mk(T value, String name, Result<Boolean> result, String problem) {
        if ($Str.mk(name).isBlank()) {
            throw Problems.illegalArg(
                String.format(FORMAT, "name", name, BLANK)
            );
        }
        if ($Str.mk(problem).isBlank()) {
            throw Problems.illegalArg(
                String.format(FORMAT, "problem", problem, BLANK)
            );
        }
        return new ValImpl<T>(value, name, result, problem);
    }
}