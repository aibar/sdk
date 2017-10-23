package walkingdevs.http;

class StatusImpl implements Status {
    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    StatusImpl(int code, String message) {
        this.code = code;
        this.message = message;

    }
    private final int code;
    private final String message;
}