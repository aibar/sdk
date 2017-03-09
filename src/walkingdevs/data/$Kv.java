package walkingdevs.data;

import walkingdevs.val.$Val;

public class $Kv {

    public static <K, V> Kv<K, V> mk(K key, V val) {
        return new KvImpl<K, V>(
            $Val.NULL("key", key).get(),
            val
        );
    }

    public static <V> Kv<String, V> mk(String key, V val) {
        return new KvImpl<String, V>(
            $Val.Blank("key", key).get(),
            val
        );
    }
}