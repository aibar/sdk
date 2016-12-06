package walkingdevs.data;

class KvImpl<K, V> implements Kv<K, V> {
    public K key() {
        return key;
    }

    public V val() {
        return val;
    }

    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        return key() + "=" + val();
    }

    KvImpl(K key, V val) {
        this.key = key;
        this.val = val;
    }

    private final K key;
    private final V val;
}