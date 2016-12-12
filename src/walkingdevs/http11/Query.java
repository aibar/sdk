package walkingdevs.http11;

import walkingdevs.NULLSafe;
import walkingdevs.data.Kvs;

public interface Query extends NULLSafe {
    String queryString();

    Kvs<String, String> keyVals();
}