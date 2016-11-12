package walkingdevs.http11;

public interface Resp {
    int status();

    String statusMsg();

    Headers headers();

    RespBody body();
}