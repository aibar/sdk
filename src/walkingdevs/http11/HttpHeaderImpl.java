package walkingdevs.http11;

class HttpHeaderImpl implements HttpHeader {
    public String name() {
        return name;
    }

    public String value() {
        return value;
    }

    HttpHeaderImpl(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private final String name;
    private final String value;
}