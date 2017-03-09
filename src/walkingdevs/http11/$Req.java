package walkingdevs.http11;

import walkingdevs.fun.Predicate;
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
        $Val.NULL("method",method).crash();
        $Val.NULL("body", body).crash();
        $Val.mk("method", method, new Predicate<Method>() {
            @Override
            public boolean test(Method method) {
                return method == Method.GET && !body.isEmpty();
            }
        },  "For reasons unknown Http Method will be forced to change to POST. Thank you! HttpUrlConnection."
        ).crash();
        return new ReqImpl(
            $Val.NULL("url", url).get(),
            method,
            $Val.NULL("headers", headers).get(),
            body,
            $Val.Negative("readTimeout", readTimeout).get(),
            $Val.Negative("connectTimeout", connectTimeout).get()
        );
    }
}