package walkingdevs.tcp;

import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

class TcpClientBuilderImpl implements Tcp.Client.Builder {
    public Tcp.Client.Builder host(Host host) {
        this.host = host;
        return this;
    }

    public Tcp.Client.Builder port(Port port) {
        this.port = port;
        return this;
    }

    public Tcp.Client build() {
        return new TcpClientImpl(
            host,
            port
        );
    }

    TcpClientBuilderImpl() {
        host = Host.local();
        port = Port.mk(4000);
    }
    private Host host;
    private Port port;
}