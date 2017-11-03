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
        loopThread.start();
        loopThread.setName("Exo main listener.");
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
                ), 10000);
                System.out.println("Server started....");
                while (!server.isClosed()){
                    Socket client = server.accept();
                    Thread.sleep(10L);
                    new Thread(()->{
                        try{
                            OutputStream os = client.getOutputStream();
                            handler.run(HttpRequest.mk()).writeFormattedTo(os);
                            os.flush();
                            os.close();
                            client.close();
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private final Action success;
    private boolean await;
    private ServerSocket server;
    private final Thread loopThread;

    public static void main(String[] args) {
        Http.server().build().start();
    }
}