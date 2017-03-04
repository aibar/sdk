package walkingdevs.val;

import walkingdevs.exceptions.$Exceptions;
import walkingdevs.fun.Predicate;
import walkingdevs.str.$Str;


public class $Val {
    public static <T> Val<T> NULL(String name, final T val) {
        return mk(
                val,
                new Predicate<T>() {
                    @Override
                    public boolean test(T t) {
                        return val == null;
                    }
                },
                $Exceptions.NULL(name)
        );
    }

    // Int
    public static Val<Integer> Negative(String name, final int val) {
        return mk(
                name,
                val,
                new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return val < 0;
                    }
                },
                "Can not be Negative"
        );
    }

    public static Val<Integer> LessThan1(String name, final int val) {
        return mk(
                name,
                val,
                new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return val < 1;
                    }
                },
                "Can not be < 1"
        );
    }

    public static Val<Integer> OutSide(String name, final int val, final int left, final int right) {
        return mk(
                name,
                val,
                new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return (val < left || val > right);
                    }
                },
                "Can not be < 1"
        );
    }

    // String
    public static Val<String> Blank(String name, final String val) {
        if ($Str.mk(name).isBlank()) {
            throw $Exceptions.Blank("name");
        }
        return mk(
                val,
                new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return $Str.mk(val).isBlank();
                    }
                },
                $Exceptions.Blank(name)
        );
    }

    public static Val<String> Empty(String name, final String val) {
        if ($Str.mk(name).isBlank()) {
            throw $Exceptions.Blank("name");
        }
        return mk(
                val,
                new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return $Str.mk(val).isEmpty();
                    }
                },
                $Exceptions.IllegalArgument(
                        name,
                        val,
                        "Can not be Empty"
                )
        );
    }

    public static <T> Val<T> mk(String name, T val, Predicate<T> predicate, String exp) {
        if ($Str.mk(name).isBlank()) {
            throw $Exceptions.Blank("Val.mk:name");
        }
        return mk(
                val,
                predicate,
                $Exceptions.IllegalArgument(
                        name,
                        val,
                        exp
                )
        );
    }

    public static <T> Val<T> mk(T val, Predicate<T> predicate, RuntimeException toThrow) {
        if (predicate == null) {
            throw $Exceptions.NULL("Val.mk:predicate");
        }
        if (toThrow == null) {
            throw $Exceptions.NULL("Val.mk:toThrow");
        }
        return new ValImpl<T>(val, predicate, toThrow);
    }
}