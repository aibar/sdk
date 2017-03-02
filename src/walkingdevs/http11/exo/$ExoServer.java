package walkingdevs.http11.exo;

import walkingdevs.http11.IP;
import walkingdevs.http11.Port;

/**
 * Created by olzhas on 28.02.17.
 */
public class $ExoServer {
    public static ExoServer mk(IP ip, Port port) {
        return new ExoServerImpl(ip, port);
    }
}
