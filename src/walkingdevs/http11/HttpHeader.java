package walkingdevs.http11;

public interface HttpHeader {
    String name();

    String value();

    static HttpHeader mk(String name, String value) {
        return new HttpHeaderImpl(name, value);
    }
}