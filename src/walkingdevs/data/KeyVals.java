package walkingdevs.data;

import walkingdevs.Val;

public interface KeyVals<K, V> extends Iterable<KeyVal<K, V>> {
    KeyVals<K, V> add(KeyVal<K, V> keyVal);

    KeyVals<K, V> del(K key);

    boolean has(K key);

    int size();

    static <K, V> KeyVals<K, V> mk() {
        return new KeyValsImpl<>();
    }

    static <K, V> KeyVals<K, V> mk(KeyVal<K, V>... from) {
        KeyValsImpl<K, V> keyVals = new KeyValsImpl<>();
        for (KeyVal<K, V> keyVal : from) {
            // Don't trust JVM user, never.
            keyVals.add(
                    Val.isNull(keyVal, "keyVal").getOrFail()
            );
        }
        return keyVals;
    }
}