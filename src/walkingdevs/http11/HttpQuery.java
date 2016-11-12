package walkingdevs.http11;

import walkingdevs.data.Kvs;

public interface HttpQuery {
    String queryString();

    Kvs<String, String> keyVals();
}