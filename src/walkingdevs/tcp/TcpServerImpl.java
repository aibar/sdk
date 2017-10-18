package walkingdevs.tcp;

import walkingdevs.fun.Action;
import walkingdevs.fun.Handler;
import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

import java.net.Socket;

class TcpServerImpl implements Tcp.Server {
    public void start() {
        successAction.run();
    }

    public void kill() {
    }

    TcpServerImpl(Host host, Port port, Handler<Socket> socketHandler, Action successAction, boolean await) {
        this.host = host;
        this.port = port;
        this.socketHandler = socketHandler;
        this.successAction = successAction;
        this.await = await;
    }
    private final Host host;
    private final Port port;
    private final Handler<Socket> socketHandler;
    private final Action successAction;
    private final boolean await;
}