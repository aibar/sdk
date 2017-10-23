package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;
import walkingdevs.tcp.Tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class Exo implements Http.Server {
    public void start() {
        loopThread.setDaemon(await);
        loopThread.start();
        success.run();
    }

    public boolean isAlive() {
        return false;
    }

    public void kill() {
        loopThread.isInterrupted();
    }

    Exo(Host host, Port port, Function<HttpResponse, HttpRequest> handler, Action success, boolean await) {
        this.success = success;
        this.await = await;
        loopThread = new Thread(() -> {
            ServerSocket server;
            try {
                server = new ServerSocket();
                server.bind(
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
                try (Socket client = server.accept()) {
                    handler.run(HttpRequest.mk()).writeTo(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private final Action success;
    private boolean await;
    private final Thread loopThread;

    public static void main(String[] args) {
        Tcp.server().build().start();
    }
}