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
            mVal.isIsNull(uri, "uri").get(),
            mVal.isIsNull(method, "method").get(),
            mVal.isIsNull(headers, "headers").get(),
            mVal.isIsNull(body, "body").get(),
            mVal.isNegative(readTimeout, "readTimeout").get(),
            mVal.isNegative(connectTimeout, "connectTimeout").get()
        );
    }
}