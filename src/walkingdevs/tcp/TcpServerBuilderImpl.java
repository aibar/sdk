package walkingdevs.tcp;

import walkingdevs.fun.Action;
import walkingdevs.fun.Handler;
import walkingdevs.http.Host;
import walkingdevs.http.Port;

import java.net.Socket;

class TcpServerBuilderImpl implements Tcp.Server.Builder {
    public Tcp.Server.Builder handler(Handler<Socket> socketHandler) {
        this.socketHandler = socketHandler;
        return this;
    }

    public Tcp.Server.Builder host(Host host) {
        this.host = host;
        return this;
    }

    public Tcp.Server.Builder port(Port port) {
        this.port = port;
        return this;
    }

    public Tcp.Server.Builder success(Action action) {
        successAction = action;
        return this;
    }

    public Tcp.Server.Builder await(boolean await) {
        this.await = await;
        return this;
    }

    public Tcp.Server build() {
        return new TcpServerImpl(
            host,
            port,
            socketHandler,
            successAction,
            await
        );
    }

    private Host host;
    private Port port;
    private Handler<Socket> socketHandler;
    private Action successAction;
    private boolean await;
}