package walkingdevs.http;

import walkingdevs.data.Path;

class HttpRequestBuilderImpl implements HttpRequest.Builder {
    public Builder host(Host host) {
        return this;
    }

    public Host host() {
        return host;
    }

    public Builder port(Port port) {
        return this;
    }

    public Port port() {
        return port;
    }

    public Builder method(Method method) {
        return this;
    }

    public Method method() {
        return method;
    }

    public Builder path(Path<String> path) {
        return this;
    }

    public Path<String> path() {
        return path;
    }

    public Builder version(Version version) {
        return this;
    }

    public Version version() {
        return version;
    }

    public Builder status(Status status) {
        return this;
    }

    public Status status() {
        return status;
    }

    public Builder headers(Headers headers) {
        return this;
    }

    public Headers headers() {
        return headers;
    }

    public Builder body(Body body) {
        return this;
    }

    public Body body() {
        return body;
    }

    Host host;
    Port port;
    Method method;
    Path<String> path;
    Version version;
    Status status;
    Headers headers;
    Body body;
}