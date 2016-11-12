package walkingdevs.data;

import walkingdevs.val.mVal;

public class mKv {
    public static <K, V> Kv<K, V> mk(K key, V val) {
        return new KvImpl<K, V>(
            mVal.mkIsNull(key, "key").get(),
            val
        );
    }

    public static <V> Kv<String, V> mk(String key, V val) {
        return new KvImpl<String, V>(
            mVal.mkIsBlank(key, "key").get(),
            val
        );
    }
}