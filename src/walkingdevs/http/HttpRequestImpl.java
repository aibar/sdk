package walkingdevs.http;

import walkingdevs.data.Path;

class HttpRequestImpl implements HttpRequest {
    public Host host() {
        return host;
    }

    public Port port() {
        return port;
    }

    public Method method() {
        return method;
    }

    public Path<String> path() {
        return path;
    }

    public Version version() {
        return version;
    }

    public Status status() {
        return status;
    }

    public Headers headers() {
        return headers;
    }

    public Body body() {
        return body;
    }

    HttpRequestImpl(Version version, Status status, Headers headers, Body body) {
        this.version = version;
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    private Host host;
    private Port port;
    private Method method;
    private Path<String> path;
    private Version version;
    private Status status;
    private Headers headers;
    private Body body;
}