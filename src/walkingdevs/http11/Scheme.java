package walkingdevs.http11;

import walkingdevs.fun.Result;
import walkingdevs.val.MVal;

public enum Scheme {
    Http("http"),
    Https("https");

    public static Scheme from(final String scheme) {
        MVal.mk(scheme, "scheme",
            new Result<Boolean>() {
                public Boolean get() {
                    return scheme == null || (!scheme.equals("http") && !scheme.equals("https"));
                }
            },
            "http|https"
        ).fail();
        if ("http".equals(scheme)) {
            return Http;
        } else {
            return Https;
        }
    }

    public String toString() {
        return name;
    }

    Scheme(String name) {
        this.name = name;
    }

    private final String name;
}