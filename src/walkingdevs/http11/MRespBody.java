package walkingdevs.http11;

public class MRespBody {
    static RespBody mk() {
        return mk(new byte[0]);
    }

    static RespBody mk(byte[] bytes) {
        if (bytes == null) {
            return mk();
        }
        return new RespBodyImpl(bytes);
    }
}