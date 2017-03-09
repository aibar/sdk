package walkingdevs.data;

import walkingdevs.iter.$Iter;

import java.util.*;

// Actually a map
class KvsImpl<K, V> implements Kvs<K, V> {

    public V get(K key) {
        return map.get(key);
    }

    public Kvs<K, V> put(Kv<K, V> kv) {
        if (kv != null) {
            map.put(kv.key(), kv.val());
        }
        return this;
    }

    public Kvs<K, V> put(K key, V val) {
        return put($Kv.mk(
            key,
            val
        ));
    }

    public Kvs<K, V> del(K key) {
        map.remove(key);
        return this;
    }

    public Iterable<K> keys() {
        return map.keySet();
    }

    public Iterable<V> vals() {
        return map.values();
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
            list.add($Kv.mk(
                    entry.getKey(),
                    entry.getValue()
            ));
        }
        return list.iterator();
    }

    @Override
    public String toString() {
        return $Iter.mk(this).join(", ");
    }

    KvsImpl() {
        this.map = new HashMap<K, V>();
    }

    private final Map<K, V> map;
}