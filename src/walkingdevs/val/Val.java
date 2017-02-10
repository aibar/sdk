package walkingdevs.val;

import walkingdevs.exceptions.Exceptions;
import walkingdevs.str.Str;

import java.util.function.Predicate;

// Validator
public interface Val<T> {
    void crash();

    boolean test();

    T get();

    // Common
    static <T> Val<T> NULL(T val, String name) {
        return mk(
            val,
            (v) -> v == null,
            Exceptions.NULL(name)
        );
    }

    // Int
    static Val<Integer> Negative(int val, String name) {
        return mk(
            val,
            name,
            (v) -> v < 0,
            "Can not be negative"
        );
    }

    static Val<Integer> LessThan1(int val, String name) {
        return mk(
            val,
            name,
            (v) -> v < 1,
            "Can not be < 1"
        );
    }

    static Val<Integer> OutSide(int val, String name, int left, int right) {
        return mk(
            val,
            name,
            (v) -> v < left || v > right,
            "Can not be < 1"
        );
    }

    // String
    static Val<String> Blank(String val, String name) {
        if (Str.mk(name).isBlank()) {
            throw Exceptions.Blank("name");
        }
        return mk(
            val,
            v -> Str.mk(v).isBlank(),
            Exceptions.Blank(name)
        );
    }

    static <T> Val<T> mk(T val, String name, Predicate<T> predicate, String exp) {
        if (Str.mk(name).isBlank()) {
            throw Exceptions.Blank("Val.name");
        }
        return mk(
            val,
            predicate,
            Exceptions.IllegalArgument(
                name,
                val,
                exp
            )
        );
    }

    static <T> Val<T> mk(T val, Predicate<T> predicate, RuntimeException toThrow) {
        if (predicate == null) {
            throw Exceptions.NULL("Val.predicate");
        }
        if (toThrow == null) {
            throw Exceptions.NULL("Val.toThrow");
        }
        return new ValImpl<>(val, predicate, toThrow);
    }
}