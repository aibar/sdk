package walkingdevs.http11.exo;

import walkingdevs.http11.IP;
import walkingdevs.http11.Port;

class ExoImpl implements Exo {
    public Exo bind(IP bindIP) {
        this.bindIP = bindIP;
        return this;
    }

    public Exo bind(Port bindPort) {
        this.bindPort = bindPort;
        return this;
    }

    @Override
    public Exo GET(ExoHandler exoHandler) {
        return null;
    }

    public ExoServer build() {
        return ExoServer.mk(bindIP, bindPort);
    }

    private IP bindIP;
    private Port bindPort;
}