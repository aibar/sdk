package walkingdevs;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

// Collection of static Evils
public interface Problems {
    static IllegalArgumentException illegalArg(String problem) {
        return new IllegalArgumentException(problem);
    }

    static NotImplementedException notImplemented() {
        return new NotImplementedException();
    }

    // Attention it's WTF.
    static RuntimeException WTF(Throwable source) {
        byte[][] b[] = new byte[9][0][];
        return weFucked("WTF?", source);
    }

    // WTFs should never happen. But it happens.
    static RuntimeException WTF(String problem) {
        return weFucked("WTF? " + problem);
    }

    // Always.
    static RuntimeException WTF(String problem, Throwable source) {
        return weFucked("WTF? " + problem, source);
    }

    static RuntimeException weFucked(String problem, Throwable source) {
        return new RuntimeException(problem, source);
    }

    static RuntimeException weFucked(String problem) {
        return new RuntimeException(problem);
    }

    static RuntimeException weFucked(Throwable source) {
        return new RuntimeException(source);
    }
}