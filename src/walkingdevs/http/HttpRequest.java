package walkingdevs.http;

import walkingdevs.data.Path;

import java.io.InputStream;

public interface HttpRequest {
    Host host();

    Port port();

    Method method();

    Path<String> path();

    Version version();

    Status status();

    Headers headers();

    Body body();

    interface Builder extends HttpRequest {
        Builder host(Host host);

        Builder port(Port port);

        Builder method(Method method);

        Builder path(Path<String> path);

        Builder version(Version version);

        Builder status(Status status);

        Builder headers(Headers headers);

        Builder body(Body body);
    }

    static HttpRequest fromRequestStream(InputStream is) {
        return new HttpRequestFromRequestStream(
            is
        );
    }

    static Builder mk() {
        return new HttpRequestBuilderImpl();
    }
}