package walkingdevs.exceptions;

public class IllegalArgument extends RuntimeException {
    IllegalArgument() {
    }

    IllegalArgument(String msg) {
        super(msg);
    }
}