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
    public synchronized void start() {
        try {
            server = new ServerSocket();
            server.bind(new InetSocketAddress(this.host.inet(), this.port.get()));
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
                        this.handler.run(HttpRequest.mk()).writeFormattedTo(client.getOutputStream());
                        Thread.sleep(10L);
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                Thread.sleep(10L);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        success.run();
    }

    public synchronized boolean isAlive() {
        return threadPool.isShutdown();
    }

    public synchronized void kill() {
        threadPool.shutdown();
    }

    Exo(Host host, Port port, Function<HttpResponse, HttpRequest> handler, Action success, boolean await) {
        this.host = host;
        this.port = port;
        this.handler = handler;
        this.success = success;
        this.await = await;
    }
    private final Action success;
    private boolean await;
    private ServerSocket server;
    private ExecutorService threadPool;
    private Host host;
    private Port port;
    private Function<HttpResponse, HttpRequest> handler;
    public static void main(String[] args) {
        Http.server().build().start();
    }

}