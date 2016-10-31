package walkingdevs.http11;

public class MHttpHeaders {
    public static HttpHeaders mk() {
        return new HttpHeadersImpl();
    }

    public static HttpHeaders mk(HttpHeaders other) {
        HttpHeaders httpHeaders = mk();
        for (HttpHeader httpHeader : other) {
            httpHeaders.add(httpHeader.name(), httpHeader.value());
        }
        return httpHeaders;
    }

    public static HttpHeaders mk(HttpHeader... other) {
        HttpHeaders httpHeaders = mk();
        for (HttpHeader httpHeader : other) {
            httpHeaders.add(httpHeader.name(), httpHeader.value());
        }
        return httpHeaders;
    }
}