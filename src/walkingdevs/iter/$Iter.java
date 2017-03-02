package walkingdevs.iter;

import java.util.ArrayList;

public class $Iter {
    public static <T> Iter<T> mk() {
        return mk(new ArrayList<T>());
    }

    public static <T> Iter<T> mk(T... array) {
        ArrayList<T> iterable = new ArrayList<T>();
        for (T t : array) {
            iterable.add(t);
        }
        return mk(iterable);
    }

    public static <T> Iter<T> mk(Iterable<T> iterable) {
        if (iterable == null) {
            return mk();
        }
        return new IterImpl<T>(iterable);
    }
}