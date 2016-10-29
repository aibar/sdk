package walkingdevs.http11;

import walkingdevs.iter.Iter;
import walkingdevs.data.KeyVals;

class HttpQueryImpl implements HttpQuery {
    public String queryString() {
        if (kvs.isEmpty()) {
            return "";
        }
        return Iter.mk(kvs).join("&");
    }

    public KeyVals<String, String> keyVals() {
        return kvs;
    }

    @Override
    public String toString() {
        return queryString();
    }

    HttpQueryImpl(KeyVals<String, String> kvs) {
        this.kvs = kvs;
    }

    private final KeyVals<String, String> kvs;
}