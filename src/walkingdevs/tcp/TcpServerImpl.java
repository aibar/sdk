package walkingdevs.tcp;

import walkingdevs.fun.Action;
import walkingdevs.fun.Handler;
import walkingdevs.http.Host;
import walkingdevs.http.Port;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class TcpServerImpl implements Tcp.Server {
    public void start() {
        loopThread.setDaemon(!await);
        loopThread.start();
        successAction.run();
    }

    public void kill() {
        loopThread.interrupt();
    }

    TcpServerImpl(Host host, Port port, Handler<Socket> socketHandler, Action successAction, boolean await) {
        this.successAction = successAction;
        this.await = await;
        loopThread = new Thread(() -> {
            ServerSocket serverSocket;
            try {
                serverSocket = new ServerSocket();
                serverSocket.bind(
                    new InetSocketAddress(
                        host.inet(),
                        port.get()
                    )
                );
            } catch (IOException e) {
                throw new RuntimeException(
                    e
                );
            }
            while (!Thread.currentThread().isInterrupted()) {
                try (Socket socket = serverSocket.accept()) {
                    socketHandler.handle(socket);
                } catch (IOException e) {
                    throw new RuntimeException(
                        e
                    );
                }
            }
        });
    }
    private final Action successAction;
    private final boolean await;
    private final Thread loopThread;
}