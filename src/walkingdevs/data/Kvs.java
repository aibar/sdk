package walkingdevs.data;

public interface Kvs<K, V> extends Iterable<Kv<K, V>> {
    Kvs<K, V> add(Kv<K, V> kv);

    Kvs<K, V> del(K key);

    boolean has(K key);

    Kv<K, V> get(K key);

    int size();

    boolean isEmpty();
}