package walkingdevs.http11.exo;

import walkingdevs.http11.IP;
import walkingdevs.http11.Port;

/**
 * Created by olzhas on 28.02.17.
 */
public class $Exo {
    public static Exo mk(IP bindIP, Port bindPort) {
        return new ExoImpl()
                .bind(bindIP)
                .bind(bindPort);
    }
}
