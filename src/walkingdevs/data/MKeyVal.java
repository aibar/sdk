package walkingdevs.data;

import walkingdevs.val.MVal;

public class MKeyVal {
    public static <K, V> KeyVal<K, V> mk(K key, V val) {
        return new KeyValImpl<K, V>(
                MVal.mkIsNull(key, "key").get(),
                val
        );
    }

    public static <V> KeyVal<String, V> mk(String key, V val) {
        return new KeyValImpl<String, V>(
                MVal.mkIsBlank(key, "key").get(),
                val
        );
    }
}