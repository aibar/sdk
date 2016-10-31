package walkingdevs.http11;

import walkingdevs.data.KeyVal;

public class MHttpForm {
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