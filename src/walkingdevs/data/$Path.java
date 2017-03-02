package walkingdevs.data;

import walkingdevs.str.$Str;

/**
 * Created by olzhas on 28.02.17.
 */
public class $Path {
    // httpPath should start with "/"
    public static Path<String> mkFromHttpPath(String httpPath) {
        if ($Str.mk(httpPath).isBlank() || httpPath.length() == 1) {
            return mk();
        }
        // Cut query string
        int i = httpPath.indexOf('?');
        if (i != -1) {
            httpPath = httpPath.substring(0, i);
        }
        return mk(httpPath);
    }

    // pathString should start with delimiter
    public static Path<String> mk(String pathString) {
        Path<String> path = mk();
        if ($Str.mk(pathString).isBlank() || pathString.length() == 1) {
            return path;
        }
        char delimiter = pathString.charAt(0);
        int i = 0;
        while (++i < pathString.length()) {
            if (pathString.charAt(i) != delimiter) {
                int end = pathString.indexOf(delimiter, i);
                if (end == -1) {
                    return path.add(pathString.substring(i));
                }
                path.add(pathString.substring(i, end));
                i = end;
            }
        }
        return path;
    }

    public static <T> Path<T> mk(T... items) {
        Path<T> path = mk();
        for (T item : items) {
            path.add(item);
        }
        return path;
    }

    public static <T> Path<T> mk() {
        return new PathImpl<T>();
    }
}
