package walkingdevs.http;

class HeaderImpl implements Header {
    public String name() {
        return name;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return name + ": " + value;
    }

    HeaderImpl(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private final String name;
    private final String value;
}