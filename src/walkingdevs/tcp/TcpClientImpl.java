package walkingdevs.tcp;

import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

class TcpClientImpl implements Tcp. Client {
    public Tcp.Client write(String data) {
        try {
            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
            oos.writeUTF(data);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    TcpClientImpl(Host host, Port port) {
        try {
            socket = new Socket(host.inet().getHostAddress(), port.get());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Socket socket;
}