package walkingdevs.http11;

import walkingdevs.iter.Iter;
import walkingdevs.data.Kvs;

class HttpQueryImpl implements HttpQuery {
    public String queryString() {
        if (kvs.isEmpty()) {
            return "";
        }
        return Iter.mk(kvs).join("&");
    }

    public Kvs<String, String> keyVals() {
        return kvs;
    }

    @Override
    public String toString() {
        return queryString();
    }

    HttpQueryImpl(Kvs<String, String> kvs) {
        this.kvs = kvs;
    }

    private final Kvs<String, String> kvs;
}