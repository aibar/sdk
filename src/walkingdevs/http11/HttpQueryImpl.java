package walkingdevs.http11;

import walkingdevs.data.KeyVals;
import walkingdevs.iter.MIter;

class HttpQueryImpl implements HttpQuery {
    public String queryString() {
        if (kvs.isEmpty()) {
            return "";
        }
        return "?" + MIter.mk(kvs).join("&");
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