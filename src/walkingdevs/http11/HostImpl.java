package walkingdevs.http11;

import walkingdevs.exceptions.Try;

import java.net.InetAddress;

class HostImpl implements Host {
    public InetAddress inet() {
        return Try.mk(() -> InetAddress.getLocalHost()).Do();
    }
}