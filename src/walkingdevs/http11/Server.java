package walkingdevs.http11;

public interface Server {
    void listen(Port listenPort);

    Server start();

    Server stop();

    void await();

    static Server mk(IP listenIP, Port listenPort) {
        return new ServerImpl();
    }
}