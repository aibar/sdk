package walkingdevs.data;

import walkingdevs.Problems;

class EmptyKv<K, V> implements Kv<K, V> {
    public K key() {
        throw Problems.objectIsEmpty();
    }

    public V val() {
        throw Problems.objectIsEmpty();
    }

    public boolean isEmpty() {
        return true;
    }

    @Override
    public String toString() {
        return "empty";
    }
}