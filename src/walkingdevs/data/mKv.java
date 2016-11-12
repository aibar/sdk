package walkingdevs.data;

import walkingdevs.val.mVal;

public class mKv {
    public static <K, V> Kv<K, V> mk(K key, V val) {
        return new KvImpl<K, V>(
            mVal.isIsNull(key, "key").get(),
            val
        );
    }

    public static <V> Kv<String, V> mk(String key, V val) {
        return new KvImpl<String, V>(
            mVal.isIsBlank(key, "key").get(),
            val
        );
    }
}