package walkingdevs.http11;

public interface Resp {
    int status();

    String statusMsg();

    HttpHeaders headers();

    RespBody body();
}