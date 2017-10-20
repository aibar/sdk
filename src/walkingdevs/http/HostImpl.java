package walkingdevs.http;

import walkingdevs.exceptions.Try;

import java.net.InetAddress;

class HostImpl implements Host {
    public InetAddress inet() {
        return inetAddress;
    }

    HostImpl(String host) {
        inetAddress = Try.mk(() -> InetAddress.getByName(host)).Do();
    }
    private final InetAddress inetAddress;
}