package walkingdevs.http11;

import walkingdevs.data.KeyVal;
import walkingdevs.data.KeyVals;
import walkingdevs.iter.Iter;

class HttpFormImpl implements HttpForm {
    public String get() {
        return Iter.mk(kvs).join("&");
    }

    public HttpForm add(KeyVal<String, String> kv) {
        kvs.add(kv);
        return this;
    }

    public HttpForm del(String key) {
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

    private final KeyVals<String, String> kvs = KeyVals.mk();
}