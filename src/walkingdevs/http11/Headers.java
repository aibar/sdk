package walkingdevs.http11;

public interface Headers extends Iterable<Header> {
    boolean has(String header);

    Headers add(String name, String value);

    Headers del(String name);

    static Headers mk() {
        return new HeadersImpl();
    }

    static Headers mk(Headers other) {
        Headers headers = mk();
        for (Header header : other) {
            headers.add(header.name(), header.value());
        }
        return headers;
    }

    static Headers mk(Header... other) {
        Headers headers = mk();
        for (Header header : other) {
            headers.add(header.name(), header.value());
        }
        return headers;
    }
}