package walkingdevs.http11;

import walkingdevs.data.Kv;

public interface HttpForm {
    String get();

    HttpForm add(Kv<String, String> kv);

    HttpForm del(String key);

    boolean has(String key);

    int size();

    boolean isEmpty();
}