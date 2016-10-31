package walkingdevs.http11;

import walkingdevs.data.KeyVal;

public interface HttpForm {
    String get();

    HttpForm add(KeyVal<String, String> kv);

    HttpForm del(String key);

    boolean has(String key);

    int size();

    boolean isEmpty();
}