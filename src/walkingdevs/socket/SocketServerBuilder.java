package walkingdevs.socket;

import walkingdevs.http11.Port;
import walkingdevs.http11.exo.ExoServer;

public interface SocketServerBuilder {
    void listen(Port listenPort);

    ExoServer build();
}