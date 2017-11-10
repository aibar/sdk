package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

import java.io.*;
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
                            is = Channels.newInputStream(client);
                            os = Channels.newOutputStream(client);
                            getURIFromHeader(readHeader());
                            handler.run(HttpRequest.mk()).writeFormattedTo(os);
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
    private OutputStream os;
    private InputStream is;

    private String readHeader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String ln;
        while (true) {
            ln = reader.readLine();
            if (ln == null || ln.isEmpty()) {
                break;
            }
            builder.append(ln + System.getProperty("line.separator"));
        }
        return builder.toString();
    }

    private String getURIFromHeader(String header) {
        int from = header.indexOf(" ") + 1;
        int to = header.indexOf(" ", from);
        String uri = header.substring(from, to);
        int paramIndex = uri.indexOf("?");
        if (paramIndex != -1) {
            uri = uri.substring(0, paramIndex);
        }
        return "wwww/" + uri;
    }

    public static void main(String[] args) {
        Http.server().build().start();
    }

}