package walkingdevs.http11.exo;

import walkingdevs.http11.IP;
import walkingdevs.http11.Port;

public interface ExoServer {
    ExoServer start(boolean await);

    // Start and Await
    ExoServer start();

    boolean isStarted();

    // Not "stop", but "kill", because it actually kills the ExoServer
    // All current requests will be ignored
    ExoServer kill();

    static ExoServer mk(IP ip, Port port) {
        return new ExoServerImpl(ip, port);
    }
}