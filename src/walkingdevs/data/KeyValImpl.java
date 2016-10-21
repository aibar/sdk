package walkingdevs.data;

class KeyValImpl<K, V> implements KeyVal<K, V> {
    public K key() {
        return key;
    }

    public V val() {
        return val;
    }

    @Override
    public String toString() {
        return key() + "=" + val();
    }

    KeyValImpl(K key, V val) {
        this.key = key;
        this.val = val;
    }

    private final K key;
    private final V val;
}