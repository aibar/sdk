package walkingdevs.http11;

import java.net.InetAddress;

public interface Host {
    InetAddress inet();

    static Host mk(String host) {
        return new HostImpl();
    }

    static Host all() {
        return mk("0.0.0.0");
    }

    static Host local() {
        return mk("127.0.0.1");
    }
}