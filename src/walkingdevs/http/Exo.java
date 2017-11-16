package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;
import walkingdevs.tcp.Tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Exo implements Http.Server {
    public void start() {
        server.start();
    }

    public boolean isAlive() {
        return server.isAlive();
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
            .success(()->{
                success.run();
            })
            .handler(socket->{
                    new Thread(()->{
                        try {
                            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String s;
                            while ((s=in.readLine())!=null){
                                System.out.println(s);
                                if (s.isEmpty()){
                                    break;
                                }
                            }
                            handler.run(HttpRequest.mk()).writeFormattedTo(socket.getOutputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            )
            .build();
    }
    private final Tcp.Server server;

    public static void main(String[] args) {
        Http.server().build().start();
    }

}