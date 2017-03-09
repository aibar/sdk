package walkingdevs.http11;

import walkingdevs.val.$Val;

public class $ReqBuilder {
    public static ReqBuilder GET(String uriString) {
        return mk(uriString).method(Method.GET);
    }

    public static ReqBuilder mk(String uriString) {
        return mk($Url.parse(uriString));
    }

    public static ReqBuilder GET(Url url) {
        return mk(url).method(Method.GET);
    }

    public static ReqBuilder mk(Url url) {
        return new ReqBuilderImpl(
            $Val.NULL("url", url).get()
        );
    }
}