package walkingdevs.http11;

import walkingdevs.data.Kvs;

public interface Query {
    String queryString();

    Kvs<String, String> keyVals();
}