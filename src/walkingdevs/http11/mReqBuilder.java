package walkingdevs.http11;

import walkingdevs.val.mVal;

public class mReqBuilder {
    public static ReqBuilder GET(String uriString) {
        return mk(uriString).method(Method.GET);
    }

    public static ReqBuilder mk(String uriString) {
        return mk(mUrl.parse(uriString));
    }

    public static ReqBuilder GET(Url url) {
        return mk(url).method(Method.GET);
    }

    public static ReqBuilder mk(Url url) {
        return new ReqBuilderImpl(
            mVal.isIsNull(url, "url").get()
        );
    }
}