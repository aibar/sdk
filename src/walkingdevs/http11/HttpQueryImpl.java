package walkingdevs.http11;

import walkingdevs.data.Kvs;
import walkingdevs.iter.mIter;

class HttpQueryImpl implements HttpQuery {
    public String queryString() {
        if (kvs.isEmpty()) {
            return "";
        }
        return "?" + mIter.mk(kvs).join("&");
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