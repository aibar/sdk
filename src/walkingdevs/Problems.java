package walkingdevs;

// Collection of static Evils
public class Problems {
    public static IllegalArgumentException illegalArg(String problem) {
        return new IllegalArgumentException(problem);
    }

    public static RuntimeException notImplemented() {
        return new RuntimeException("Not implemented");
    }

    // Attention it's WTF.
    public static RuntimeException WTF(Throwable source) {
        return weFucked("WTF?", source);
    }

    // WTFs should never happen. But it happens.
    public static RuntimeException WTF(String problem) {
        return weFucked("WTF? " + problem);
    }

    // Always.
    public static RuntimeException WTF(String problem, Throwable source) {
        return weFucked("WTF? " + problem, source);
    }

    public static RuntimeException weFucked(String problem, Throwable source) {
        return new RuntimeException(problem, source);
    }

    public static RuntimeException weFucked(String problem) {
        return new RuntimeException(problem);
    }

    public static RuntimeException weFucked(Throwable source) {
        return new RuntimeException(source);
    }
}