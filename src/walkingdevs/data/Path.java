package walkingdevs.data;

import walkingdevs.NULLSafe;
import walkingdevs.str.Str;

public interface Path<Item> extends NULLSafe {
    Path<Item> add(Item item);

    Path<Item> add(Path<Item> other);

    Item head();

    Item last();

    Path<Item> parent();

    Path<Item> tail();

    // Delimit with "/"
    String string();

    String string(char delimiter);

    Iterable<Item> items();

    boolean isAlone();

    static <T> Path<T> mk() {
        return new PathImpl<>();
    }

    static <T> Path<T> mk(T... items) {
        Path<T> res = mk();
        if (items.length == 1 && items[0] == null) {
            return res;
        }
        for (T item : items) {
            res.add(item);
        }
        return res;
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
                i = end;
            }
        }
        return ret;
    }

    static Path<String> mkFromHttpPath(String httpPath) {
        // Cut query string
        int i = httpPath.indexOf('?');
        if (i != -1) {
            httpPath = httpPath.substring(0, i);
        }
        return mk(httpPath);
    }
}