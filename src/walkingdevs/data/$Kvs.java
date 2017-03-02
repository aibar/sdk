package walkingdevs.data;

public class $Kvs {

    public static <K, V> Kvs<K, V> mk(K key, V val) {
        return mk(
                $Kv.mk(key, val)
        );
    }

    public static <K, V> Kvs<K, V> mk(Kv<K, V>... from) {
        Kvs<K, V> kvs = mk();
        for (Kv<K, V> kv : from) {
            kvs.put(kv);
        }
        return kvs;
    }
    public static <K, V> Kvs<K, V> mk() {
        return new KvsImpl<>();
    }
}