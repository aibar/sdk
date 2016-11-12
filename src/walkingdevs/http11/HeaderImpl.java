package walkingdevs.http11;

class HeaderImpl implements Header {
    public String name() {
        return name;
    }

    public String value() {
        return value;
    }

    HeaderImpl(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private final String name;
    private final String value;
}