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
        Url url,
        Method method,
        Headers headers,
        Body body,
        int readTimeout,
        int connectTimeout
    ) {
        Val.NULL("method", method).crash();
        Val.NULL("body", body).crash();
        if (!body.isEmpty()) {
            Val.mk(
                "method", method,
                (v) -> !(v == Method.GET),
                "For reasons unknown HTTP Method will be forced to change to POST. Thank you! HttpUrlConnection."
            ).crash();
        }
        return new ReqImpl(
            Val.NULL("url", url).get(),
            method,
            Val.NULL("headers", headers).get(),
            body,
            Val.Negative("readTimeout", readTimeout).get(),
            Val.Negative("connectTimeout", connectTimeout).get()
        );
    }
}