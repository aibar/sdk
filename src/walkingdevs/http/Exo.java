package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Exo implements Http.Server {
    public void start() {
        loopThread.setDaemon(await);
        loopThread.setName("Server thread");
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
                server = AsynchronousServerSocketChannel.open().bind(
                    new InetSocketAddress(host.inet(), port.get())
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
            threadPool = Executors.newCachedThreadPool();
            try {
                while (!Thread.currentThread().isInterrupted()){
                    Future<AsynchronousSocketChannel> future= server.accept();
                    final AsynchronousSocketChannel client= future.get();
                    threadPool.execute(()->{
                        try {
                            handler.run(HttpRequest.mk()).writeFormattedTo(Channels.newOutputStream(client));
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        this.success = success;
        this.await = await;
    }
    private final Action success;
    private boolean await;
    private Thread loopThread;
    private AsynchronousServerSocketChannel server;
    private  ExecutorService threadPool;


    public static void main(String[] args) {
        Http.server().build().start();
    }

}