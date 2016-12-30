package walkingdevs.data;

public interface Kvs<K, V> extends Iterable<Kv<K, V>> {
    boolean has(K key);

    V get(K key);

    Kvs<K, V> add(Kv<K, V> kv);

    Kvs<K, V> add(K key, V val);

    Kvs<K, V> del(K key);

    Iterable<K> keys();

    Iterable<V> vals();

    int size();

    boolean isEmpty();

    static <K, V> Kvs<K, V> mk(Kv<K, V>... from) {
        Kvs<K, V> kvs = mk();
        for (Kv<K, V> kv : from) {
            kvs.add(kv);
        }
        return kvs;
    }

    static <K, V> Kvs<K, V> mk() {
        return new KvsImpl<>();
    }
}