package walkingdevs;

import java.nio.charset.Charset;

public enum Charsets {
    Default(Charset.defaultCharset().name()),

    UTF8("UTF-8"),

    KOI8("KOI8");

    public String toString() {
        return name;
    }

    Charsets(String name) {
        this.name = name;
    }

    private final String name;
}