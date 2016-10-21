package walkingdevs.http11;

import walkingdevs.str.Str;

class HttpHeaderImpl implements HttpHeader {
    public String name() {
        return name;
    }

    public String value() {
        return value;
    }

    HttpHeaderImpl(String name, String value) {
        if (Str.mk(name).isBlank()) {
            throw new IllegalArgumentException("Http header name cannot be blank");
        }
        this.name = name;
        this.value = value;
    }

    private final String name;
    private final String value;
}