package walkingdevs.iter;

import java.util.Iterator;

public class MItor {
    public static <T> Itor<T> mk() {
        return new ItorEmptyImpl<T>();
    }

    public static <T> Itor<T> mk(Iterator<T> iterator) {
        if (iterator == null) {
            return mk();
        }
        return new ItorImpl<T>(iterator);
    }
}