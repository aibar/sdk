package walkingdevs.http11;

import walkingdevs.str.mStr;

public class mHeader {
    public static Header mk(String name, String value) {
        if (mStr.mk(name).isBlank()) {
            throw new IllegalArgumentException("Http header name cannot be blank");
        }
        return new HeaderImpl(name, value);
    }
}