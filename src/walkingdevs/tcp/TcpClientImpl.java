package walkingdevs.tcp;

import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

import java.io.IOException;
import java.net.Socket;

class TcpClientImpl implements Tcp.Client {
    public Tcp.Client write(String data) {
        try {
            socket.getOutputStream().write(
                data.getBytes()
            );
        } catch (IOException e) {
            throw new RuntimeException(
                e
            );
        }
        return this;
    }

    TcpClientImpl(Host host, Port port) {
        try {
            socket = new Socket(host.inet().getHostAddress(), port.get());
        } catch (IOException e) {
            throw new RuntimeException(
                e
            );
        }
    }
    private final Socket socket;
}