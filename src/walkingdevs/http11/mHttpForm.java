package walkingdevs.http11;

import walkingdevs.data.Kv;

public class mHttpForm {
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