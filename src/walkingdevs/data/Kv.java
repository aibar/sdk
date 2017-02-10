package walkingdevs.data;

import walkingdevs.NULLSafe;
import walkingdevs.val.Val;

public interface Kv<K, V> extends NULLSafe {
    K key();

    V val();

    static <K, V> Kv<K, V> mk(K key, V val) {
        return new KvImpl<>(
            Val.NULL(key, "key").get(),
            val
        );
    }

    static <V> Kv<String, V> mk(String key, V val) {
        return new KvImpl<>(
            Val.Blank(key, "key").get(),
            val
        );
    }

    static <K, V> Kv<K, V> mk() {
        return new EmptyKv<>();
    }
}