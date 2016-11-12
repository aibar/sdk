package walkingdevs.http11;

import walkingdevs.val.mVal;

public class mReqBuilder {
    public static ReqBuilder GET(String uriString) {
        return mk(uriString).method(Method.GET);
    }

    public static ReqBuilder mk(String uriString) {
        return mk(mHttpURI.parse(uriString));
    }

    public static ReqBuilder GET(HttpURI uri) {
        return mk(uri).method(Method.GET);
    }

    public static ReqBuilder mk(HttpURI uri) {
        return new ReqBuilderImpl(
            mVal.isIsNull(uri, "uri").get()
        );
    }
}