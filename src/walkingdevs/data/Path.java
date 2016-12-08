package walkingdevs.data;

import walkingdevs.NULLSafe;
import walkingdevs.str.Str;

public interface Path<Item> extends NULLSafe {
    Path<Item> add(Item item);

    Item last();

    Path<Item> parent();

    Path<Item> tail();

    // Delimit with "/"
    String string();

    String string(char delimiter);

    Iterable<Item> items();

    static <T> Path<T> mk() {
        return new PathImpl<>();
    }

    static <T> Path<T> mk(T... items) {
        Path<T> ret = mk();
        for (T item : items) {
            ret.add(item);
        }
        return ret;
    }

    static Path<String> mk(String pathString) {
        Path<String> ret = mk();
        if (Str.mk(pathString).isBlank() || pathString.length() == 1) {
            return ret;
        }
        char delimiter = pathString.charAt(0);
        int i = 0;
        while (++i < pathString.length()) {
            if (pathString.charAt(i) != delimiter) {
                int end = pathString.indexOf(delimiter, i);
                if (end == -1) {
                    return ret.add(pathString.substring(i));
                }
                ret.add(pathString.substring(i, end));
            }
        }
        return ret;
    }
}