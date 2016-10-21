package walkingdevs.data;

import walkingdevs.Val;

public interface KeyVal<K, V> {
    K key();

    V val();

    static <K, V> KeyVal<K, V> mk(K key, V val) {
        return new KeyValImpl<>(
                Val.isNull(key, "key").getOrFail(),
                val
        );
    }

    static <V> KeyVal<String, V> mk(String key, V val) {
        return new KeyValImpl<>(
                Val.isBlank(key, "key").getOrFail(),
                val
        );
    }
}