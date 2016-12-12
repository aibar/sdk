package walkingdevs.data;

import walkingdevs.str.$Str;

public class  $Path<Item> {
    public static <T> Path<T> mk() {
        return new PathImpl<T>();
    }

    public static <T> Path<T> mk(T... items) {
        Path<T> res = mk();
        if (items.length == 1 && items[0] == null) {
            return res;
        }
        for (T item : items) {
            res.add(item);
        }
        return res;
    }

    public static Path<String> mk(String pathString) {
        Path<String> ret = mk();
        if ($Str.mk(pathString).isBlank() || pathString.length() == 1) {
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

    public static Path<String> mkHttp(String httpPath) {
        // Cut query string
        int i = httpPath.indexOf('?');
        if (i != -1) {
            httpPath = httpPath.substring(0, i);
        }
        return mk(httpPath);
    }
}