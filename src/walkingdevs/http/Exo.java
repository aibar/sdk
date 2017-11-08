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
        loopThread.setDaemon(!await);
        loopThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            }catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        });
        this.success = success;
        this.await = await;
    }
    private final Action success;
    private boolean await;
    private final Thread loopThread;
    private ServerSocket server;
    private  ExecutorService threadPool;


    public static void main(String[] args) {
        Http.server().build().start();
    }

}