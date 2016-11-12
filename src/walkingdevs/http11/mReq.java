package walkingdevs.http11;

import walkingdevs.val.mVal;

public class mReq {
    public static Req mk(
        HttpURI uri,
        Method method,
        Headers headers,
        Body body,
        int readTimeout,
        int connectTimeout
    ) {
        return new ReqImpl(
            mVal.mkIsNull(uri, "uri").get(),
            mVal.mkIsNull(method, "method").get(),
            mVal.mkIsNull(headers, "headers").get(),
            mVal.mkIsNull(body, "body").get(),
            mVal.mkNegative(readTimeout, "readTimeout").get(),
            mVal.mkNegative(connectTimeout, "connectTimeout").get()
        );
    }
}