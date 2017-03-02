package walkingdevs.http11;

import walkingdevs.data.Kvs;
import walkingdevs.data.$Kv;
import walkingdevs.data.$Kvs;
import walkingdevs.fun.Predicate;
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
        $Val.Blank(queryString, "queryString").crash();
        $Val.mk(queryString, "queryString",
            new Predicate<String>() {
                @Override
                public boolean test(String s) {
                    return queryString.startsWith("?");
                }
            },
            "Cannot start with '?'"
        ).crash();
        $Val.mk(queryString, "queryString",
                new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return queryString.endsWith("#");
                    }
                },
            "Cannot end with '#'"
        ).crash();

        Kvs<String, String> kvs = $Kvs.mk();
        for (String kvString : queryString.split("&")) {
            String[] kv = kvString.split("=");
            if (kv.length == 1) {
                kvs.put($Kv.mk(kv[0], ""));
            } else if (kv.length == 2) {
                kvs.put($Kv.mk(kv[0], kv[1]));
            }
        }
        return mk(kvs);
    }
}