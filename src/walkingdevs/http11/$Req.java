package walkingdevs.http11;

import walkingdevs.fun.Result;
import walkingdevs.val.$Val;

public class $Req {
    public static Req mk(
        Url url,
        final Method method,
        Headers headers,
        final Body body,
        int readTimeout,
        int connectTimeout
    ) {
        $Val.isIsNull(method, "method").fail();
        $Val.isIsNull(body, "body").fail();
        $Val.mk(method, "method", new Result<Boolean>() {
            public Boolean get() {
                return method == Method.GET && !body.isEmpty();
            }},
            "For reasons unknown Http Method will be forced to change to POST. Thank you! HttpUrlConnection."
        ).fail();
        return new ReqImpl(
            $Val.isIsNull(url, "url").get(),
            method,
            $Val.isIsNull(headers, "headers").get(),
            body,
            $Val.isNegative(readTimeout, "readTimeout").get(),
            $Val.isNegative(connectTimeout, "connectTimeout").get()
        );
    }
}