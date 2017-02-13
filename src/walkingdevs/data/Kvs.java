package walkingdevs.data;

public interface Kvs<K, V> extends Iterable<Kv<K, V>> {
    V get(K key);

    Kvs<K, V> put(Kv<K, V> kv);

    Kvs<K, V> put(K key, V val);

    Kvs<K, V> del(K key);

    boolean has(K key);

    Iterable<K> keys();

    Iterable<V> vals();

    int size();

    boolean isEmpty();

    static <K, V> Kvs<K, V> mk(K key, V val) {
        return mk(
            Kv.mk(key, val)
        );
    }

    static <K, V> Kvs<K, V> mk(Kv<K, V>... from) {
        Kvs<K, V> kvs = mk();
        for (Kv<K, V> kv : from) {
            kvs.put(kv);
        }
        return kvs;
    }

    static <K, V> Kvs<K, V> mk() {
        return new KvsImpl<>();
    }
}