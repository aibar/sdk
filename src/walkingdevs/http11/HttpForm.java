package walkingdevs.http11;

import walkingdevs.data.Kv;

public interface HttpForm {
    String get();

    HttpForm add(Kv<String, String> kv);

    HttpForm del(String key);

    boolean has(String key);

    int size();

    boolean isEmpty();

    static HttpForm mk(Kv<String, String>... from) {
        HttpForm form = mk();
        for (Kv<String, String> kv : from) {
            form.add(kv);
        }
        return form;
    }

    static HttpForm mk() {
        return new HttpFormImpl();
    }
}