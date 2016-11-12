package walkingdevs.http11;

import walkingdevs.iter.Iter;
import walkingdevs.data.Kvs;

class QueryImpl implements Query {
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

    QueryImpl(Kvs<String, String> kvs) {
        this.kvs = kvs;
    }

    private final Kvs<String, String> kvs;
}