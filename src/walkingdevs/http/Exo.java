package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;
import walkingdevs.tcp.Tcp;

import java.io.IOException;

class Exo implements Http.Server {
    public void start() {
        server.start();
    }

    public boolean isAlive() {

        return false;
    }

    public void kill() {
        server.kill();
    }

    Exo(Host host, Port port, Function<HttpResponse, HttpRequest> handler, Action success, boolean await) {
        System.out.println("Server started on port: " + port.get());
        server = Tcp
            .server()
            .host(host)
            .port(port)
            .await(!await)
            .handler(socket->{
                    new Thread(()->{
                        try {
                            handler.run(HttpRequest.mk()).writeFormattedTo(socket.getOutputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                        }
                    }).start();
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            )
            .success(()->{
                success.run();
            })
            .build();
    }
    private final Tcp.Server server;

    public static void main(String[] args) {
        Http.server().build().start();
    }

}