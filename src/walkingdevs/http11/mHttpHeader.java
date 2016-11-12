package walkingdevs.http11;

import walkingdevs.str.mStr;

public class mHttpHeader {
    public static HttpHeader mk(String name, String value) {
        if (mStr.mk(name).isBlank()) {
            throw new IllegalArgumentException("Http header name cannot be blank");
        }
        return new HttpHeaderImpl(name, value);
    }
}