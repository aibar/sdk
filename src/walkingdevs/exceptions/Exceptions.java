package walkingdevs.exceptions;

// Collection of static Evils
// TODO: aspects to show correct line
public interface Exceptions {
    static IllegalArgument NULL(String name) {
        return IllegalArgument(
            String.format("Argument <%s>: Carl, object can not be NULL!", name)
        );
    }

    static IllegalArgument Blank(String name) {
        return IllegalArgument(
            String.format("Argument <%s>: Can not be blank", name)
        );
    }

    static IllegalArgument IllegalArgument(String arg, Object val) {
        return IllegalArgument(
            arg,
            val,
            "Invalid"
        );
    }

    static IllegalArgument IllegalArgument(String arg, Object val, String exp) {
        return IllegalArgument(
            String.format("Argument <%s> with value <%s>: %s", arg, val, exp)
        );
    }

    static IllegalArgument IllegalArgument(String exp) {
        return new IllegalArgument(exp);
    }

    static RuntimeException WTF(Throwable source) {
        return weFucked("WTF?", source);
    }

    static RuntimeException WTF(String exp) {
        return weFucked("WTF? " + exp);
    }

    static RuntimeException WTF(String exp, Throwable source) {
        return weFucked("WTF? " + exp, source);
    }

    static RuntimeException weFucked(String exp, Throwable source) {
        return new RuntimeException(exp, source);
    }

    static RuntimeException weFucked(String exp) {
        return new RuntimeException(exp);
    }

    static RuntimeException weFucked(Throwable source) {
        return new RuntimeException(source);
    }
}