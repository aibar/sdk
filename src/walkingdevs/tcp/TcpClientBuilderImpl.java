package walkingdevs.tcp;

import walkingdevs.http.Host;
import walkingdevs.http.Port;

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

    private Host host;
    private Port port;
}