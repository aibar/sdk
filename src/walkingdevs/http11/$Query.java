package walkingdevs.http11;

import walkingdevs.data.Kvs;
import walkingdevs.data.$Kv;
import walkingdevs.data.$Kvs;
import walkingdevs.fun.Result;
import walkingdevs.val.$Val;

public class $Query {
    public static Query mk() {
        Kvs<String, String> kvs = $Kvs.mk();
        return mk(kvs);
    }

    public static Query mk(Kvs<String, String> keyVals) {
        return new QueryImpl(keyVals);
    }

    public static Query mk(final String queryString) {
        $Val.isIsBlank(queryString, "queryString").fail();
        $Val.mk(queryString, "queryString",
            new Result<Boolean>() {
                public Boolean get() {
                    return queryString.startsWith("?");
                }
            },
            "Cannot start with '?'"
        ).fail();
        $Val.mk(queryString, "queryString",
            new Result<Boolean>() {
                public Boolean get() {
                    return queryString.endsWith("#");
                }
            },
            "Cannot end with '#'"
        ).fail();

        Kvs<String, String> kvs = $Kvs.mk();
        for (String kvString : queryString.split("&")) {
            String[] kv = kvString.split("=");
            if (kv.length == 1) {
                kvs.add($Kv.mk(kv[0], ""));
            } else if (kv.length == 2) {
                kvs.add($Kv.mk(kv[0], kv[1]));
            }
        }
        return mk(kvs);
    }
}