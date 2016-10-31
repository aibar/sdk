package walkingdevs.http11;

import walkingdevs.val.MVal;

public class MReq {
    public static Req mk(
        HttpURI uri,
        Method method,
        HttpHeaders headers,
        Body body,
        int readTimeout,
        int connectTimeout
    ) {
        return new ReqImpl(
                MVal.mkIsNull(uri, "uri").get(),
                MVal.mkIsNull(method, "method").get(),
                MVal.mkIsNull(headers, "headers").get(),
                MVal.mkIsNull(body, "body").get(),
                MVal.mkNegative(readTimeout, "readTimeout").get(),
                MVal.mkNegative(connectTimeout, "connectTimeout").get()
        );
    }
}