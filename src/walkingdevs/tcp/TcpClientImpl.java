package walkingdevs.tcp;

import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

class TcpClientImpl implements Tcp.Client {
    public Tcp.Client write(String data) {
        return this;
    }

    TcpClientImpl(Host host, Port port) {
    }
}