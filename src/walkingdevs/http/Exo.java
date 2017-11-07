package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class Exo implements Http.Server {
    public void start() {
        loopThread.setDaemon(!await);
        loopThread.setName("Exo main listener.");
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
        this.success = success;
        this.await = await;
        loopThread = new Thread(()->{
            ServerSocket server;
            try {
                server = new ServerSocket();
                server.bind(new InetSocketAddress(host.inet(), port.get()));
                System.out.println("Exo started...");
                while (!server.isClosed()){
                    try {
                        Socket client = server.accept();
                        new Thread(()->{
                            try {
                                handler.run(HttpRequest.mk()).writeFormattedTo(client.getOutputStream());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }).start();
                        Thread.sleep(10L);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private final Action success;
    private boolean await;
    private Thread loopThread;

    public static void main(String[] args) {
        Http.server().build().start();
    }
}