package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

class Exo implements Http.Server {
    public void start() {
        success.run();
    }

    public boolean isAlive() {
        return false;
    }

    public void kill() {
    }

    Exo(Host host, Port port, Function<HttpResponse, HttpRequest> handler, Action success, boolean await) {
        this.success = success;
    }
    private final Action success;
}