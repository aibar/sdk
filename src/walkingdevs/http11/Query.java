package walkingdevs.http11;

import walkingdevs.data.Kv;
import walkingdevs.data.Kvs;
import walkingdevs.vals.Vals;

public interface Query {
    String queryString();

    Kvs<String, String> keyVals();

    static Query mk() {
        return mk(Kvs.mk());
    }

    static Query mk(Kvs<String, String> kvs) {
        return new QueryImpl(kvs);
    }

    static Query mk(String queryString) {
        Vals.string("queryString", queryString)
            .cannotBeBlank()
            .cannotStartWith("?")
            .cannotEndWith("#")
            .crash();
        Kvs<String, String> kvs = Kvs.mk();
        for (String kvString : queryString.split("&")) {
            String[] kv = kvString.split("=");
            if (kv.length == 1) {
                kvs.add(Kv.mk(kv[0], ""));
            } else if (kv.length == 2) {
                kvs.add(Kv.mk(kv[0], kv[1]));
            }
        }
        return mk(kvs);
    }
}