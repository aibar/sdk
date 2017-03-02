package walkingdevs.socket;

import walkingdevs.http11.IP;
import walkingdevs.http11.Port;

/**
 * Created by olzhas on 28.02.17.
 */
public class $SocketServerBuilder {
    public static SocketServerBuilder mk(IP listenIP, Port listenPort) {
        return new SocketServerBuilderImpl();
    }
}
