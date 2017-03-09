package walkingdevs.exceptions;

/**
 * Created by olzhas on 28.02.17.
 */
public class $Exceptions {
    public static IllegalArgument NULL(String name) {
        return IllegalArgument(
                String.format("Argument <%s>: Carl, object can not be NULL!", name)
        );
    }

    public static IllegalArgument Blank(String name) {
        return IllegalArgument(
                String.format("Argument <%s>: Can not be Blank", name)
        );
    }

    public static IllegalArgument IllegalArgument(String arg, Object val) {
        return IllegalArgument(
                arg,
                val,
                "Invalid"
        );
    }

    public static IllegalArgument IllegalArgument(String arg, Object val, String exp) {
        return IllegalArgument(
                String.format("Argument <%s> with value <%s>: %s", arg, val, exp)
        );
    }

    public static IllegalArgument IllegalArgument(String exp) {
        return new IllegalArgument(exp);
    }

    public static NotImplemented NotImplemented() {
        return new NotImplemented();
    }

    public static RuntimeException WTF(Throwable source) {
        return weFucked("WTF?", source);
    }

    public static RuntimeException WTF(String exp) {
        return weFucked("WTF? " + exp);
    }

    public static RuntimeException WTF(String exp, Throwable source) {
        return weFucked("WTF? " + exp, source);
    }

    public static RuntimeException weFucked(String exp, Throwable source) {
        return new RuntimeException(exp, source);
    }

    public static RuntimeException weFucked(String exp) {
        return new RuntimeException(exp);
    }

    public static RuntimeException weFucked(Throwable source) {
        return new RuntimeException(source);
    }
}
