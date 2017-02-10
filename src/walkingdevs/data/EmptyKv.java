package walkingdevs.data;

class EmptyKv<K, V> implements Kv<K, V> {
    public K key() {
        return null;
    }

    public V val() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    @Override
    public String toString() {
        return "empty";
    }
}