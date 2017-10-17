package walkingdevs.http11.exo;

import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

public interface Exo {
    Exo bind(Host bindHost);

    Exo bind(Port bindPort);

    Exo GET(ExoHandler exoHandler);

    ExoServer build();

    static Exo mk(Host bindHost, Port bindPort) {
        return new ExoImpl()
            .bind(bindHost)
            .bind(bindPort);
    }

    static Exo mk(Host bindHost) {
        return mk(
            bindHost,
            Port.mk(8080)
        );
    }

    static Exo mk() {
        return mk(
            Host.local(),
            Port.mk(8080)
        );
    }
}