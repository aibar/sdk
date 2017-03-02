package walkingdevs.iter;

public class $Itor {
    public static <T> Itor<T> mk() {
        return new ItorEmpty<T>();
    }

    public static <T> Itor<T> mk(T... array) {
        return mkFromArray(array);
    }

    public static <T> Itor<T> mkFromArray(T[] array) {
        if (array == null) {
            return mk();
        }
        return new ItorImpl<T>(array);
    }
}