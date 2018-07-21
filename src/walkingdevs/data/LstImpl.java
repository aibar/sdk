package walkingdevs.data;

import java.util.ArrayList;
import java.util.Arrays;

class LstImpl<T> extends ArrayList<T> implements Lst<T> {
    LstImpl(T[] items) {
        addAll(Arrays.asList(items));
    }
}