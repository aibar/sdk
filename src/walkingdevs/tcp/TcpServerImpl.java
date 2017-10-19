package walkingdevs.tcp;

import walkingdevs.fun.Action;
import walkingdevs.fun.Handler;
import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class TcpServerImpl implements Tcp.Server {
    public void start() {
        loopThread = new Thread(() -> {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(port.get());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Started");
            while (!loopThread.isInterrupted()){
                try(Socket socket = serverSocket.accept()) {
                    try {
                        System.out.println("Sleeping");
                        Thread.sleep(10000);
                        System.out.println("Sleeping end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    socketHandler.handle(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        loopThread.setDaemon(!await);
        loopThread.start();
        successAction.run();
    }

    public void kill() {
    }

    TcpServerImpl(Host host, Port port, Handler<Socket> socketHandler, Action successAction, boolean await) {
        this.host = host;
        this.port = port;
        this.socketHandler = socketHandler;
        this.successAction = successAction;
        this.await = await;
    }
    private final Host host;
    private final Port port;
    private final Handler<Socket> socketHandler;
    private final Action successAction;
    private final boolean await;
    private Thread loopThread;
}