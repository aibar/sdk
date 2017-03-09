package walkingdevs.http11;

import walkingdevs.fun.Predicate;
import walkingdevs.val.$Val;

public enum Scheme {
    Http("http"),
    Https("https");

    public static Scheme from(final String scheme) {
        $Val.mk(scheme, "scheme",
            new Predicate<String>() {
                @Override
                public boolean test(String s) {
                    return scheme == null || (!scheme.equals("http") && !scheme.equals("https"));
                }
            },
            "http|https"
        ).crash();
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