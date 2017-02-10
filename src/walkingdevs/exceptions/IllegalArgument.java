package walkingdevs.exceptions;

public class IllegalArgument extends RuntimeException {
    public IllegalArgument(String msg) {
        super(msg);
    }
}