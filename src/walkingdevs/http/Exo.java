package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

import javax.net.ServerSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class Exo implements Http.Server {
    public void start() {
        serverThread.setDaemon(await);
        serverThread.setName("Server thread");
        serverThread.start();
        success.run();
    }

    public boolean isAlive() {
        return serverThread.isAlive();
    }

    public void kill() {
        serverThread.interrupt();
    }

    Exo(Host host, Port port, Function<HttpResponse, HttpRequest> handler, Action success, boolean await) {
        serverThread = new Thread(()->{
            ServerSocket serverSocket = null;
            try {
                serverSocket = ServerSocketFactory.getDefault().createServerSocket(port.get());
                System.out.println("Server started on port: " + serverSocket.getLocalPort() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (!serverThread.isInterrupted()){
                try {
                    Socket clientSocket = serverSocket.accept();
                    clientThread = new Thread(()->{
                        try {
                            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                            String s;
                            while ((s=in.readLine())!=null){
                                System.out.println(s);
                                if (s.isEmpty()){
                                    break;
                                }
                            }
                            handler.run(HttpRequest.mk()).writeFormattedTo(clientSocket.getOutputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    clientThread.start();
                } catch (IOException e) {
                    System.out.println("Failed to establish connection.");
                }
            }
        });
        this.success = success;
        this.await = await;
    }
    private final Action success;
    private boolean await;
    private Thread serverThread;
    private Thread clientThread;

    public static void main(String[] args) {
        Http.server().build().start();
    }

}