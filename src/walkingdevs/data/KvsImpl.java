package walkingdevs.data;

import walkingdevs.iter.mIter;

import java.util.*;

// Actually a Map!
class KvsImpl<K, V> implements Kvs<K, V> {
    public Kvs<K, V> add(Kv<K, V> kv) {
        if (kv != null) {
            map.put(kv.key(), kv.val());
        }
        return this;
    }

    public Kvs<K, V> del(K key) {
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
    public Iterator<Kv<K, V>> iterator() {
        List<Kv<K, V>> list = new ArrayList<Kv<K, V>>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            list.add(mKv.mk(entry.getKey(), entry.getValue()));
        }
        return list.iterator();
    }

    @Override
    public String toString() {
        return mIter.mk(this).join(", ");
    }

    private final Map<K, V> map = new HashMap<K, V>();
}