package walkingdevs.http11;

public interface ServerBuilder {
    void listen(Port listenPort);

    Server build();

    static ServerBuilder mk(IP listenIP, Port listenPort) {
        return new ServerBuilderImpl();
    }
}