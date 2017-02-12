package walkingdevs.http11;

import walkingdevs.data.Kv;
import walkingdevs.data.Kvs;
import walkingdevs.iter.Iter;

class FormImpl implements Form {
    public String get() {
        return Iter.mk(kvs).join("&");
    }

    public Form add(Kv<String, String> kv) {
        kvs.put(kv);
        return this;
    }

    public Form del(String key) {
        kvs.del(key);
        return this;
    }

    public boolean has(String key) {
        return kvs.has(key);
    }

    public int size() {
        return kvs.size();
    }

    public boolean isEmpty() {
        return kvs.isEmpty();
    }

    private final Kvs<String, String> kvs = Kvs.mk();
}