package walkingdevs.tcp;

import walkingdevs.exceptions.Try;
import walkingdevs.fun.Action;
import walkingdevs.fun.Handler;
import walkingdevs.http11.Host;
import walkingdevs.http11.Port;
import walkingdevs.str.Str;
import walkingdevs.stream.BufferedIs;

import java.net.Socket;

class TcpServerBuilderImpl implements Tcp.Server.Builder {
    public Tcp.Server.Builder handler(Handler<Socket> socketHandler) {
        return this;
    }

    public Tcp.Server.Builder host(Host host) {
        return this;
    }

    public Tcp.Server.Builder port(Port port) {
        return this;
    }

    public Tcp.Server.Builder success(Action action) {
        return this;
    }

    public Tcp.Server.Builder await(boolean await) {
        return this;
    }

    public Tcp.Server build() {
        return new TcpServerImpl(
            host,
            port,
            socketHandler
        );
    }

    TcpServerBuilderImpl() {
        host = Host.all();
        port = Port.mk(4000);
        socketHandler = socket -> {
            Try.mk(() -> {
                for (byte[] bytes : BufferedIs.mk(socket.getInputStream(), 1024)) {
                    System.out.println(
                        Str.mk(bytes)
                    );
                }
                return Void.TYPE;
            });
        };
    }

    private Host host;
    private Port port;
    private Handler<Socket> socketHandler;
}