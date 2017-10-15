package walkingdevs.http11;

import java.io.IOException;
import java.io.InputStream;

public interface Headers extends Iterable<Header> {
    boolean has(String header);

    Header get(String name);

    Headers add(String name, String value);

    Headers del(String name);

    static Headers parseFromRequest(InputStream is) throws IOException {
        return new HeadersFromRequest(is);
    }

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