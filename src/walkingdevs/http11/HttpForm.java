package walkingdevs.http11;

import walkingdevs.data.KeyVal;

public interface HttpForm {
    String get();

    HttpForm add(KeyVal<String, String> kv);

    HttpForm del(String key);

    boolean has(String key);

    int size();

    boolean isEmpty();

    static HttpForm mk(KeyVal<String, String>... from) {
        HttpForm form = mk();
        for (KeyVal<String, String> kv : from) {
            form.add(kv);
        }
        return form;
    }

    static HttpForm mk() {
        return new HttpFormImpl();
    }
}