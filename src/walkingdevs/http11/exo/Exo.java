package walkingdevs.http11.exo;

import walkingdevs.http11.IP;
import walkingdevs.http11.Port;

public interface Exo {
    Exo bind(IP bindIP);

    Exo bind(Port bindPort);

    Exo GET(ExoHandler exoHandler);

    ExoServer build();

    static Exo mk(IP bindIP, Port bindPort) {
        return new ExoImpl()
            .bind(bindIP)
            .bind(bindPort);
    }
}