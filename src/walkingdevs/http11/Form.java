package walkingdevs.http11;

import walkingdevs.data.Kv;

public interface Form {
    String get();

    Form add(Kv<String, String> kv);

    Form del(String key);

    boolean has(String key);

    int size();

    boolean isEmpty();
}