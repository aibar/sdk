package walkingdevs.tcp;

import walkingdevs.fun.Handler;
import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

import java.net.Socket;

public interface Tcp {
    static TcpServer server(Host host, Port port, Handler<Socket> socketHandler) {
        return new TcpServerImpl(
            host,
            port,
            socketHandler
        );
    }

    static TcpServer server(Port port, Handler<Socket> socketHandler) {
        return server(
            Host.all(),
            port,
            socketHandler
        );
    }

    static void client(Host host, Port port, Handler<TcpClient> handler) {
        handler.handle(
            new TcpClientImpl(
                host,
                port
            )
        );
    }

    static void client(Port port, Handler<TcpClient> handler) {
        client(
            Host.all(),
            port,
            handler
        );
    }
}