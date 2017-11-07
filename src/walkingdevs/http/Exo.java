package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Exo implements Http.Server {
    public void start() {
        success.run();
    }

    public boolean isAlive() {
        return threadPool.isShutdown();
    }

    public void kill() {
        threadPool.shutdown();
    }

    Exo(Host host, Port port, Function<HttpResponse, HttpRequest> handler, Action success, boolean await) {
        this.success = success;
        this.await = await;
        try {
            server = new ServerSocket();
            server.bind(new InetSocketAddress(host.inet(), port.get()));
            System.out.println("Server started....");
        } catch (IOException e) {
            e.printStackTrace();
        }
        threadPool = Executors.newCachedThreadPool();
        try {
            while (!Thread.currentThread().isInterrupted()){
                Socket client = server.accept();
                threadPool.submit(()->{
                    try {
                        handler.run(HttpRequest.mk()).writeFormattedTo(client.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private final Action success;
    private boolean await;
    private ServerSocket server;
    private ExecutorService threadPool;
    public static void main(String[] args) {
        Http.server().build().start();
    }
}