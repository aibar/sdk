package walkingdevs.http11;

import walkingdevs.val.MVal;

public class MReqBuilder {
    public static ReqBuilder GET(String uriString) {
        return mk(uriString).method(Method.GET);
    }

    public static ReqBuilder mk(String uriString) {
        return mk(MHttpURI.parse(uriString));
    }

    public static ReqBuilder GET(HttpURI uri) {
        return mk(uri).method(Method.GET);
    }

    public static ReqBuilder mk(HttpURI uri) {
        return new ReqBuilderImpl(
                MVal.mkIsNull(uri, "uri").get()
        );
    }
}