package walkingdevs.http;

import walkingdevs.vals.Vals;

public enum Scheme {
    Http("http"),
    Https("https");

    public String toString() {
        return name;
    }

    public static Scheme from(String scheme) {
        Vals.mk("scheme", scheme)
            .cannotBeNULL()
            .add(
                "http||https",
                (v) -> !(v.equals("http") || v.equals("https"))
            )
            .crash();
        if ("http".equals(scheme)) {
            return Http;
        } else {
            return Https;
        }
    }

    Scheme(String name) {
        this.name = name;
    }
    private final String name;
}