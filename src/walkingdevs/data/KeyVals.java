package walkingdevs.data;

public interface KeyVals<K, V> extends Iterable<KeyVal<K, V>> {
    KeyVals<K, V> add(KeyVal<K, V> kv);

    KeyVals<K, V> del(K key);

    boolean has(K key);

    int size();

    boolean isEmpty();

    static <K, V> KeyVals<K, V> mk(KeyVal<K, V>... from) {
        KeyVals<K, V> kvs = mk();
        for (KeyVal<K, V> kv : from) {
            kvs.add(kv);
        }
        return kvs;
    }

    static <K, V> KeyVals<K, V> mk() {
        return new KeyValsImpl<>();
    }
}