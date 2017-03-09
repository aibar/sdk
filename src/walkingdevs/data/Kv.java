package walkingdevs.data;

public interface Kv<K, V> {
    K key();

    V val();
}