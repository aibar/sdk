package walkingdevs.http11;

import walkingdevs.exceptions.Try;

import java.net.InetAddress;

class HostImpl implements Host {
    public InetAddress inet() {
        return inetAddress;
    }

    public HostImpl(String host) {
        inetAddress = Try.mk(() -> InetAddress.getByName(host)).Do();
    }

    InetAddress inetAddress;
}