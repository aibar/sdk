package walkingdevs.val;

import walkingdevs.Problems;
import walkingdevs.fun.Result;
import walkingdevs.str.Str;

public interface Val<T> {
    void fail();

    T get();

    String FORMAT = "Arg. <%s> with value <%s>: %s";

    String BANG = "Null check. BANG.";

    String BLANK = "Cannot be Blank.";

    static <T> Val<T> isNull(T value, String name) {
        if (Str.mk(name).isBlank()) {
            throw Problems.illegalArg(
                String.format(FORMAT, "name", name, BLANK)
            );
        }
        return mk(
            value,
            name,
            () -> value == null,
            BANG
        );
    }

    static Val<String> isBlank(String value, String name) {
        if (Str.mk(name).isBlank()) {
            throw Problems.illegalArg(
                String.format(FORMAT, "name", name, BLANK)
            );
        }
        return mk(
            value,
            name,
            () -> Str.mk(value).isBlank(),
            BLANK
        );
    }

    static <T> Val<T> mk(T value, String name, Result<Boolean> result, String problem) {
        if (Str.mk(name).isBlank()) {
            throw Problems.illegalArg(
                String.format(FORMAT, "name", name, BLANK)
            );
        }
        if (Str.mk(problem).isBlank()) {
            throw Problems.illegalArg(
                String.format(FORMAT, "problem", problem, BLANK)
            );
        }
        return new ValImpl<>(value, name, result, problem);
    }
}