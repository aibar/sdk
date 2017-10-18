package walkingdevs.tcp;

class TcpClientBuilderImpl implements Tcp.Client.Builder {
    public Tcp.Client build() {
        return new TcpClientImpl();
    }

    public TcpReq req(String data) {
        return null;
    }

    TcpClientBuilderImpl() {
    }
}