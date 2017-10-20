package walkingdevs.http;

public interface Port {
    int get();

    static Port mk(int val) {
//        Val.
        return new PortImpl(val);
    }
}