package walkingdevs.data;

public class MKeyVals {
    public static <K, V> KeyVals<K, V> mk(KeyVal<K, V>... from) {
        KeyVals<K, V> kvs = mk();
        for (KeyVal<K, V> kv : from) {
            kvs.add(kv);
        }
        return kvs;
    }

    public static <K, V> KeyVals<K, V> mk() {
        return new KeyValsImpl<K, V>();
    }
}