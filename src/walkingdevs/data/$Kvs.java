package walkingdevs.data;

public class $Kvs {
    public static <K, V> Kvs<K, V> mk(Kv<K, V>... from) {
        Kvs<K, V> kvs = mk();
        for (Kv<K, V> kv : from) {
            kvs.add(kv);
        }
        return kvs;
    }

    public static <K, V> Kvs<K, V> mk() {
        return new KvsImpl<K, V>();
    }
}