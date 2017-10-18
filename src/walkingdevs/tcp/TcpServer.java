package walkingdevs.tcp;

import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

public interface TcpServer {
    void listen(Host host, Port port);

    void kill();
}