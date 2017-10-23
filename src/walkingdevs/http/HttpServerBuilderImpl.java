package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

class HttpServerBuilderImpl implements Http.Server.Builder {
    public Http.Server.Builder handler(Function<HttpResponse, HttpRequest> handler) {
        this.handler = handler;
        return this;
    }

    public Function<HttpResponse, HttpRequest> handler() {
        return handler;
    }

    public Http.Server.Builder host(Host host) {
        this.host = host;
        return this;
    }

    public Host host() {
        return host;
    }

    public Http.Server.Builder port(Port port) {
        this.port = port;
        return this;
    }

    public Port port() {
        return port;
    }

    public Http.Server.Builder success(Action action) {
        success = action;
        return this;
    }

    public Action success() {
        return success;
    }

    public Http.Server.Builder await(boolean await) {
        this.await = await;
        return this;
    }

    public boolean await() {
        return await;
    }

    private Host host;
    private Port port;
    private boolean await;
    private Function<HttpResponse, HttpRequest> handler;
    private Action success;
}