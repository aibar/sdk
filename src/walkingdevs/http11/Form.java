package walkingdevs.http11;

import walkingdevs.data.Kv;

public interface Form {
    String get();

    Form add(Kv<String, String> kv);

    Form del(String key);

    boolean has(String key);

    int size();

    boolean isEmpty();

    static Form mk(Kv<String, String>... from) {
        Form form = mk();
        for (Kv<String, String> kv : from) {
            form.add(kv);
        }
        return form;
    }

    static Form mk() {
        return new FormImpl();
    }
}