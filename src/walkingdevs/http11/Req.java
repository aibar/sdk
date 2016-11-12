package walkingdevs.http11;

import walkingdevs.fun.Handler;
import walkingdevs.stream.BufferedIs;
import walkingdevs.val.Val;

public interface Req {
    Resp send();

    // If you are faced with a Large data
    // You are responsible to handle the body in place
    // response.body().isEmpty() would be true
    RespNoBody send(Handler<BufferedIs> bufferedIsHandler);

    void sendAsync(Handler<Resp> responseHandler);

    void sendAsync(Handler<Resp> respHandler, Handler<BufferedIs> bufferedIsHandler);

    static Req mk(
        HttpURI uri,
        Method method,
        HttpHeaders headers,
        Body body,
        int readTimeout,
        int connectTimeout
    ) {
        return new ReqImpl(
            Val.isNull(uri, "uri").get(),
            Val.isNull(method, "method").get(),
            Val.isNull(headers, "headers").get(),
            Val.isNull(body, "body").get(),
            Val.mk(
                readTimeout,
                "readTimeout",
                () -> readTimeout < 0,
                "Cannot be negative"
            ).get(),
            Val.mk(
                connectTimeout,
                "connectTimeout",
                () -> connectTimeout < 0,
                "Cannot be negative"
            ).get()
        );
    }
}