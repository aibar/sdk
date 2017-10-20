package walkingdevs.http;

class PortImpl implements Port {
    public int get() {
        return val;
    }

    PortImpl(int val) {
        this.val = val;
    }

    private final int val;
}