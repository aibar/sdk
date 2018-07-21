package walkingdevs.data;

import java.util.List;

public interface Lst<T> extends List<T> {
    static <T> Lst<T> of(T... items) {
        return new LstImpl(items);
    }
}