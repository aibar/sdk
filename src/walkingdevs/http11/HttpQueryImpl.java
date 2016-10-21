package walkingdevs.http11;

import walkingdevs.Iter;
import walkingdevs.data.KeyVals;

class HttpQueryImpl implements HttpQuery {
    public String queryString() {
        if (keyVals.size() < 1) {
            return "";
        }
        return Iter.mk(keyVals).join("&");
    }

    public KeyVals<String, String> keyVals() {
        return keyVals;
    }

    HttpQueryImpl(KeyVals<String, String> keyVals) {
        this.keyVals = keyVals;
    }

    @Override
    public String toString() {
        return queryString();
    }

    private final KeyVals<String, String> keyVals;
}