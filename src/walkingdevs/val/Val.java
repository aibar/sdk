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
    static <T> Val<T> NULL(String name, T val) {
        return mk(
            val,
            (v) -> v == null,
            Exceptions.NULL(name)
        );
    }

    // Int
    static Val<Integer> Negative(String name, int val) {
        return mk(
            name,
            val,
            (v) -> v < 0,
            "Can not be Negative"
        );
    }

    static Val<Integer> LessThan1(String name, int val) {
        return mk(
            name,
            val,
            (v) -> v < 1,
            "Can not be < 1"
        );
    }

    static Val<Integer> OutSide(String name, int val, int left, int right) {
        return mk(
            name,
            val,
            (v) -> v < left || v > right,
            "Can not be < 1"
        );
    }

    // String
    static Val<String> Blank(String name, String val) {
        if (Str.mk(name).isBlank()) {
            throw Exceptions.Blank("name");
        }
        return mk(
            val,
            v -> Str.mk(v).isBlank(),
            Exceptions.Blank(name)
        );
    }

    static Val<String> Empty(String name, String val) {
        if (Str.mk(name).isBlank()) {
            throw Exceptions.Blank("name");
        }
        return mk(
            val,
            v -> Str.mk(v).isEmpty(),
            Exceptions.IllegalArgument(
                name,
                val,
                "Can not be Empty"
            )
        );
    }

    static <T> Val<T> mk(String name, T val, Predicate<T> predicate, String exp) {
        if (Str.mk(name).isBlank()) {
            throw Exceptions.Blank("Val.mk:name");
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
            throw Exceptions.NULL("Val.mk:predicate");
        }
        if (toThrow == null) {
            throw Exceptions.NULL("Val.mk:toThrow");
        }
        return new ValImpl<>(val, predicate, toThrow);
    }
}