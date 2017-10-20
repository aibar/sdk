package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

class HttpServerBuilderImpl implements Http.Server.Builder {
    public Http.Server.Builder handler(Function<HttpResponse, HttpRequest> handler) {
        return this;
    }

    public Function<HttpResponse, HttpRequest> handler() {
        return null;
    }

    public Http.Server.Builder host(Host host) {
        return this;
    }

    public Host host() {
        return null;
    }

    public Http.Server.Builder port(Port port) {
        return this;
    }

    public Port port() {
        return null;
    }

    public Http.Server.Builder success(Action action) {
        success = action;
        return this;
    }

    public Action success() {
        return success;
    }

    public Http.Server.Builder await(boolean await) {
        return this;
    }

    public boolean await() {
        return false;
    }

    private Action success;
}