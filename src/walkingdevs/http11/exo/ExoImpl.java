package walkingdevs.http11.exo;

import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

class ExoImpl implements Exo {
    public Exo bind(Host bindHost) {
        this.bindHost = bindHost;
        return this;
    }

    public Exo bind(Port bindPort) {
        this.bindPort = bindPort;
        return this;
    }

    public Exo GET(ExoHandler exoHandler) {
        return null;
    }

    public ExoServer build() {
        return ExoServer.mk(bindHost, bindPort);
    }

    private Host bindHost;
    private Port bindPort;
}