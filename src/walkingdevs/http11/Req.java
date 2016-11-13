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
        Val.isNull(method, "method").fail();
        Val.isNull(body, "body").fail();
        Val.mk(
            method, "method",
            () -> method != Method.POST && !body.isEmpty(),
            "For reasons unknown Http Method will be forced to change to POST. Thank you! HttpUrlConnection."
        ).fail();
        return new ReqImpl(
            Val.isNull(url, "url").get(),
            method,
            Val.isNull(headers, "headers").get(),
            body,
            Val.isNegative(readTimeout, "readTimeout").get(),
            Val.isNegative(connectTimeout, "connectTimeout").get()
        );
    }
}