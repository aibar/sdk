package walkingdevs.http11;

public interface IP {
    static IP mk() {
        return new IPImpl();
    }
}