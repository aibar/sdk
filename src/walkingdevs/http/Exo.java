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
        while (loopThread.isInterrupted())
        {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
        int i = 0;
        loopThread = new Thread(() -> {
            ServerSocket server;
            try {
                server = new ServerSocket();
                server.setReuseAddress(true);
                server.bind(
                    new InetSocketAddress(
                        host.inet(),
                        port.get()
                    )
                );
                System.out.println("Exo started...");
            } catch (IOException e) {
                throw new RuntimeException(
                    e
                );
            }
            do {
                try (Socket client = server.accept()) {
                    asyncRunner.exec(
                        new ClientHandler(handler, client)
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!server.isClosed());
        });
    }

    private final Action success;
    private boolean await;
    private final Thread loopThread;
    protected AsyncRunner asyncRunner;

    public static void main(String[] args) {
        Tcp.server().build().start();
    }
}