package walkingdevs.http;

class StatusImpl implements Status {
    public int code() {
        return 0;
    }

    public String message() {
        return null;
    }

    StatusImpl(int code, String message) {
    }
}