package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class Exo implements Http.Server {
    public void start() {
        loopThread.setDaemon(!await);
        loopThread.setName("Exo main listener.");
        loopThread.start();
        try {
            loopThread.sleep(1000);
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
        this.success = success;
        this.await = await;
        loopThread = new Thread(()->{
            try {
                server = new ServerSocket();
                server.setReuseAddress(true);
                server.bind(new InetSocketAddress(
                    host.inet(),
                    port.get()
                ));
                System.out.println("Exo started....");
                while (!server.isClosed()){
                    final Socket client = server.accept();
                    new Thread(()->{
                        try{
                            OutputStream os = client.getOutputStream();
                            handler.run(HttpRequest.mk()).writeFormattedTo(os);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                client.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private final Action success;
    private boolean await;
    private ServerSocket server;
    private Thread loopThread;

    public static void main(String[] args) {
        Http.server().build().start();
    }
}