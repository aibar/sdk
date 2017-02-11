package walkingdevs.socket;

import walkingdevs.http11.IP;
import walkingdevs.http11.Port;
import walkingdevs.http11.exo.ExoServer;

public interface SocketServerBuilder {
    void listen(Port listenPort);

    ExoServer build();

    static SocketServerBuilder mk(IP listenIP, Port listenPort) {
        return new SocketServerBuilderImpl();
    }
}