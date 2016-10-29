package walkingdevs.http11;

import walkingdevs.vals.Vals;
import walkingdevs.data.KeyVal;
import walkingdevs.data.KeyVals;
import walkingdevs.data.Tuple;
import walkingdevs.str.Str;

public interface HttpQuery {
    String queryString();

    KeyVals<String, String> keyVals();

    static HttpQuery mk() {
        return mk(KeyVals.mk());
    }

    static HttpQuery mk(KeyVals<String, String> keyVals) {
        return new HttpQueryImpl(keyVals);
    }

    static HttpQuery mk(String queryString) {
        Vals.mk(queryString, "queryString",
                Tuple.mk(
                        () -> Str.mk(queryString).isBlank(),
                        "Cannot be blank"
                ),
                Tuple.mk(
                        () -> queryString.startsWith("?"),
                        "Cannot start with '?'"
                ),
                Tuple.mk(
                        () -> queryString.endsWith("#"),
                        "Cannot end with '#'"
                )
        ).fail();
        KeyVals<String, String> kvs = KeyVals.mk();
        for (String kvString : queryString.split("&")) {
            String[] kv = kvString.split("=");
            if (kv.length == 1) {
                kvs.add(KeyVal.mk(kv[0], ""));
            } else if (kv.length == 2) {
                kvs.add(KeyVal.mk(kv[0], kv[1]));
            }
        }
        return mk(kvs);
    }
}