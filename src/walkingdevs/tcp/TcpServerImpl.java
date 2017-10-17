package walkingdevs.tcp;

import walkingdevs.fun.Handler;
import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

import java.net.Socket;

class TcpServerImpl implements TcpServer {
    public void kill() {
    }

    TcpServerImpl(Host host, Port port, Handler<Socket> socketHandler) {
    }
}