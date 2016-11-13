package walkingdevs.http11;

import walkingdevs.data.Kv;

public class $Form {
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