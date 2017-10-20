package walkingdevs.http;

import walkingdevs.data.Path;

class HttpRequestImpl implements HttpRequest {
    public Host host() {
        return null;
    }

    public Port port() {
        return null;
    }

    public Method method() {
        return null;
    }

    public Path<String> path() {
        return null;
    }

    public Version version() {
        return null;
    }

    public Status status() {
        return null;
    }

    public Headers headers() {
        return null;
    }

    public Body body() {
        return null;
    }

    HttpRequestImpl(Version version, Status status, Headers headers, Body body) {
    }
}