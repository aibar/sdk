package walkingdevs.http11;

import walkingdevs.data.KeyVals;
import walkingdevs.data.MKeyVal;
import walkingdevs.data.MKeyVals;
import walkingdevs.fun.Result;
import walkingdevs.val.MVal;

public class MHttpQuery {
    public static HttpQuery mk() {
        KeyVals<String, String> kvs = MKeyVals.mk();
        return mk(kvs);
    }

    public static HttpQuery mk(KeyVals<String, String> keyVals) {
        return new HttpQueryImpl(keyVals);
    }

    public static HttpQuery mk(final String queryString) {
        MVal.mkIsBlank(queryString, "queryString").fail();
        MVal.mk(queryString, "queryString",
            new Result<Boolean>() {
                public Boolean get() {
                    return queryString.startsWith("?");
                }
            },
            "Cannot start with '?'"
        ).fail();
        MVal.mk(queryString, "queryString",
            new Result<Boolean>() {
                public Boolean get() {
                    return queryString.endsWith("#");
                }
            },
            "Cannot end with '#'"
        ).fail();

        KeyVals<String, String> kvs = MKeyVals.mk();
        for (String kvString : queryString.split("&")) {
            String[] kv = kvString.split("=");
            if (kv.length == 1) {
                kvs.add(MKeyVal.mk(kv[0], ""));
            } else if (kv.length == 2) {
                kvs.add(MKeyVal.mk(kv[0], kv[1]));
            }
        }
        return mk(kvs);
    }
}