package walkingdevs.http11;

import walkingdevs.fun.Handler;
import walkingdevs.stream.BufferedIs;
import walkingdevs.val.$Val;

public interface Req {
    Resp send();

    // If you are faced with a Large data
    // You are responsible to handle the body in place
    // response.body().isEmpty() would be true
    RespNoBody send(Handler<BufferedIs> bufferedIsHandler);

    void sendAsync(Handler<Resp> responseHandler);

    void sendAsync(Handler<Resp> respHandler, Handler<BufferedIs> bufferedIsHandler);
}