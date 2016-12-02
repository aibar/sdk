package walkingdevs.data;

import walkingdevs.val.$Val;

public class $Kv {
    public static <K, V> Kv<K, V> mk(K key, V val) {
        return new KvImpl<K, V>(
            $Val.isIsNull(key, "key").get(),
            val
        );
    }

    public static <V> Kv<String, V> mk(String key, V val) {
        return new KvImpl<String, V>(
            $Val.isIsBlank(key, "key").get(),
            val
        );
    }

    public static <K, V> Kv<K, V> mk() {
        return new EmptyKv<K, V>();
    }
}