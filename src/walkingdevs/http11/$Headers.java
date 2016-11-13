package walkingdevs.http11;

public class $Headers {
    public static Headers mk() {
        return new HeadersImpl();
    }

    public static Headers mk(Headers other) {
        Headers httpHeaders = mk();
        for (Header httpHeader : other) {
            httpHeaders.add(httpHeader.name(), httpHeader.value());
        }
        return httpHeaders;
    }

    public static Headers mk(Header... other) {
        Headers httpHeaders = mk();
        for (Header httpHeader : other) {
            httpHeaders.add(httpHeader.name(), httpHeader.value());
        }
        return httpHeaders;
    }
}