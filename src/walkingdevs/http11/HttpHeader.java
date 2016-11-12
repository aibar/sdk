package walkingdevs.http11;

import walkingdevs.str.Str;

public interface HttpHeader {
    String name();

    String value();

    static HttpHeader mk(String name, String value) {
        if (Str.mk(name).isBlank()) {
            throw new IllegalArgumentException("Http header name cannot be blank");
        }
        return new HttpHeaderImpl(name, value);
    }
}