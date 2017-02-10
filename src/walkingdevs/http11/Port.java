package walkingdevs.http11;

public interface Port {
    int get();

    static Port mk(int val) {
//        Val.
        return new PortImpl(val);
    }
}