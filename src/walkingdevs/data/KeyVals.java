package walkingdevs.data;

public interface KeyVals<K, V> extends Iterable<KeyVal<K, V>> {
    KeyVals<K, V> add(KeyVal<K, V> kv);

    KeyVals<K, V> del(K key);

    boolean has(K key);

    int size();

    boolean isEmpty();
}