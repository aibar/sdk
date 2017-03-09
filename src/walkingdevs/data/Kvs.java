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

}