package walkingdevs.http11;

import walkingdevs.Val;
import walkingdevs.fun.Handler;
import walkingdevs.stream.BufferedIs;

public interface Request {
    Response send();

    // If you are faced with a Large data
    // You are responsible to handle the body in place
    // response.body().isEmpty() would be true
    Response send(Handler<BufferedIs> bodyIsHandler);

    void sendAsync(Handler<Response> responseHandler);

    void sendAsync(Handler<Response> responseHandler, Handler<BufferedIs> bodyIsHandler);

    static Request mk(
            HttpURI uri,
            HttpMethod method,
            HttpHeaders headers,
            Body body,
            int readTimeout,
            int connectTimeout
    ) {
        return new RequestImpl(
                Val.isNull(uri, "uri").getOrFail(),
                Val.isNull(method, "method").getOrFail(),
                Val.isNull(headers, "headers").getOrFail(),
                Val.isNull(body, "body").getOrFail(),
                Val.mk(
                        readTimeout,
                        "readTimeout",
                        readTimeout < 0,
                        "Cannot be negative"
                ).getOrFail(),
                Val.mk(
                        connectTimeout,
                        "connectTimeout",
                        connectTimeout < 0,
                        "Cannot be negative"
                ).getOrFail()
        );
    }
}