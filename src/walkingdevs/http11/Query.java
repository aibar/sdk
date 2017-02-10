package walkingdevs.http11;

import walkingdevs.NULLSafe;
import walkingdevs.vals.Vals;
import walkingdevs.data.Kv;
import walkingdevs.data.Kvs;
import walkingdevs.data.Tuple;
import walkingdevs.str.Str;

public interface Query extends NULLSafe {
    String queryString();

    Kvs<String, String> keyVals();

    static Query mk() {
        return mk(Kvs.mk());
    }

    static Query mk(Kvs<String, String> kvs) {
        return new QueryImpl(kvs);
    }

    static Query mk(String queryString) {
        Vals.mk(queryString, "queryString",
            Tuple.mk(
                (v) -> Str.mk(v).isBlank(),
                "Cannot be blank"
            ),
            Tuple.mk(
                (v) -> v.startsWith("?"),
                "Cannot start with '?'"
            ),
            Tuple.mk(
                (v) -> v.endsWith("#"),
                "Cannot end with '#'"
            )
        ).crash();
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