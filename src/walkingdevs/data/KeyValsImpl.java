package walkingdevs.data;

import walkingdevs.Iter;

import java.util.*;

// Actually a Map!
class KeyValsImpl<K, V> implements KeyVals<K, V> {
    public KeyVals<K, V> add(KeyVal<K, V> keyVal) {
        map.put(keyVal.key(), keyVal.val());
        return this;
    }

    public KeyVals<K, V> del(K key) {
        map.remove(key);
        return this;
    }

    public boolean has(K key) {
        return map.containsKey(key);
    }

    public int size() {
        return map.size();
    }

    @Override
    public Iterator<KeyVal<K, V>> iterator() {
        List<KeyVal<K, V>> list = new ArrayList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            list.add(KeyVal.mk(entry.getKey(), entry.getValue()));
        }
        return list.iterator();
    }

    @Override
    public String toString() {
        return Iter.mk(this).join(", ");
    }

    private final Map<K, V> map = new HashMap<>();
}