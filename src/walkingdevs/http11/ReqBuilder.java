package walkingdevs.http11;

import walkingdevs.val.Val;

public interface ReqBuilder {
    int readTimeout();
    ReqBuilder readTimeout(int milliseconds);

    int connectTimeout();
    ReqBuilder connectTimeout(int milliseconds);

    HttpURI uri();

    Method method();
    ReqBuilder method(Method method);

    HttpHeaders headers();
    ReqBuilder headers(HttpHeaders headers);

    Body body();
    ReqBuilder body(Body body);
    ReqBuilder body(HttpForm form);

    Req build();

    static ReqBuilder GET(String uriString) {
        return mk(uriString).method(Method.GET);
    }

    static ReqBuilder mk(String uriString) {
        return mk(HttpURI.parse(uriString));
    }

    static ReqBuilder GET(HttpURI uri) {
        return mk(uri).method(Method.GET);
    }

    static ReqBuilder mk(HttpURI uri) {
        return new ReqBuilderImpl(
                Val.isNull(uri, "uri").get()
        );
    }
}