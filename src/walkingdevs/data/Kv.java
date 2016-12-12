package walkingdevs.data;

import walkingdevs.NULLSafe;

public interface Kv<K, V> extends NULLSafe {
    K key();

    V val();
}