package walkingdevs.http11;

import walkingdevs.str.$Str;

public class $Header {
    public static Header mk(String name, String value) {
        if ($Str.mk(name).isBlank()) {
            throw new IllegalArgumentException("Http header name cannot be blank");
        }
        return new HeaderImpl(name, value);
    }
}