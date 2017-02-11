package walkingdevs.http11.exo;

import walkingdevs.http11.IP;
import walkingdevs.http11.Port;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ExoServerImpl implements ExoServer {
    public ExoServer start(boolean await) {
        loopThread = new Thread(() -> {
            ServerSocket server = null;
            try {
                server = new ServerSocket(8080);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Started");
            while (!loopThread.isInterrupted()) {
                try (Socket socket = server.accept()) {
                    try {
                        System.out.println("Sleeping");
                        Thread.sleep(15000);
                        System.out.println("Sleeping end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    socket.getOutputStream().write("HTTP/1.1 200 OK\r\n\r\nHello, world!".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Stopped");
        });
        loopThread.setDaemon(!await);
        loopThread.start();
        return this;
    }

    public ExoServer start() {
        return start(true);
    }

    public boolean isStarted() {
        return loopThread != null && loopThread.isAlive();
    }

    public ExoServer kill() {
        loopThread.interrupt();
        return this;
    }

    ExoServerImpl(IP bindIP, Port bindPort) {
        this.bindIP = bindIP;
        this.bindPort = bindPort;
    }

    private final IP bindIP;
    private final Port bindPort;
    private ServerSocket serverSocket;
    private Thread loopThread;

    public static void main(String[] args) throws InterruptedException {
        Exo.mk(null, null)
            .build()
            .start();
    }
}