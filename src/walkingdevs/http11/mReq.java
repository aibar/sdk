package walkingdevs.http11;

import walkingdevs.fun.Result;
import walkingdevs.val.mVal;

public class mReq {
    public static Req mk(
        HttpURI uri,
        final Method method,
        Headers headers,
        final Body body,
        int readTimeout,
        int connectTimeout
    ) {
        mVal.isIsNull(method, "method").fail();
        mVal.isIsNull(body, "body").fail();
        mVal.mk(method, "method", new Result<Boolean>() {
            public Boolean get() {
                return method != Method.POST && !body.isEmpty();
            }},
            "For reasons unknown Http Method will be forced to change to POST. Thank you! HttpUrlConnection."
        ).fail();
        return new ReqImpl(
            mVal.isIsNull(uri, "uri").get(),
            method,
            mVal.isIsNull(headers, "headers").get(),
            body,
            mVal.isNegative(readTimeout, "readTimeout").get(),
            mVal.isNegative(connectTimeout, "connectTimeout").get()
        );
    }
}