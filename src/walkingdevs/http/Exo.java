package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class Exo implements Http.Server {
    public void start() {
        loopThread.setDaemon(await);
        loopThread.setName("Server thread");
        loopThread.start();
        success.run();
    }

    public boolean isAlive() {
        return loopThread.isAlive();
    }

    public void kill() {
        loopThread.interrupt();
    }

    Exo(Host host, Port port, Function<HttpResponse, HttpRequest> handler, Action success, boolean await) {
        loopThread = new Thread(()->{
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket();
                serverSocket.bind(new InetSocketAddress(host.inet(), port.get()));
                System.out.println("Server started on port: " + serverSocket.getLocalPort() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (!loopThread.isInterrupted()){
                try {
                    Socket clientSocket = serverSocket.accept();
                    ClientSession session = new ClientSession(clientSocket, handler);
                    new Thread(session).start();
                } catch (IOException e) {
                    System.out.println("Failed to establish connection.");
                    System.out.println(e.getMessage());
                    System.exit(-1);
                }
            }
        });
        this.success = success;
        this.await = await;
    }
    private final Action success;
    private boolean await;
    private Thread loopThread;

    public static void main(String[] args) {
        Http.server().build().start();
    }

}