package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

import java.io.*;
import java.net.InetSocketAddress;
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
                serverSocket = new ServerSocket();
                serverSocket.bind(new InetSocketAddress(host.inet(), port.get()));
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
                            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                            String s;
                            while ((s=in.readLine())!=null){
                                System.out.println(s);
                                if (s.isEmpty()){
                                    break;
                                }
                            }
                            out.write("HTTP/1.0 200 OK\r\n");
                            out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
                            out.write("Server: Apache/0.8.4\r\n");
                            out.write("Content-Type: text/html\r\n");
                            out.write("Content-Length: 59\r\n");
                            out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
                            out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
                            out.write("\r\n");
                            out.write("Exo server is up and running.");
                            out.close();
                            in.close();
                            clientSocket.close();
                            //handler.run(HttpRequest.mk()).writeFormattedTo(clientSocket.getOutputStream());
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