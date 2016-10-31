package walkingdevs.http11;

public interface RespNoBody {
    int status();

    String statusMsg();

    HttpHeaders headers();
}