package walkingdevs.http11;

public interface HttpHeaders extends Iterable<HttpHeader> {
    boolean has(String header);

    HttpHeaders add(String name, String value);

    HttpHeaders del(String name);

    static HttpHeaders mk() {
        return new HttpHeadersImpl();
    }

    static HttpHeaders mk(HttpHeaders other) {
        HttpHeaders httpHeaders = mk();
        for (HttpHeader httpHeader : other) {
            httpHeaders.add(httpHeader.name(), httpHeader.value());
        }
        return httpHeaders;
    }

    static HttpHeaders mk(HttpHeader... other) {
        HttpHeaders httpHeaders = mk();
        for (HttpHeader httpHeader : other) {
            httpHeaders.add(httpHeader.name(), httpHeader.value());
        }
        return httpHeaders;
    }
}