package walkingdevs.http11;

import walkingdevs.data.KeyVals;

public interface HttpQuery {
    String queryString();

    KeyVals<String, String> keyVals();
}