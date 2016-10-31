package walkingdevs.data;

import walkingdevs.iter.MIter;

import java.util.*;

// Actually a Map!
class KeyValsImpl<K, V> implements KeyVals<K, V> {
    public KeyVals<K, V> add(KeyVal<K, V> kv) {
        if (kv != null) {
            map.put(kv.key(), kv.val());
        }
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

    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator<KeyVal<K, V>> iterator() {
        List<KeyVal<K, V>> list = new ArrayList<KeyVal<K, V>>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            list.add(MKeyVal.mk(entry.getKey(), entry.getValue()));
        }
        return list.iterator();
    }

    @Override
    public String toString() {
        return MIter.mk(this).join(", ");
    }

    private final Map<K, V> map = new HashMap<K, V>();
}