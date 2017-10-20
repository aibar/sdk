package walkingdevs.http;

import walkingdevs.val.Val;

public interface ReqBuilder {
    int readTimeout();
    ReqBuilder readTimeout(int milliseconds);

    int connectTimeout();
    ReqBuilder connectTimeout(int milliseconds);

    Url uri();

    Method method();
    ReqBuilder method(Method method);

    Headers headers();
    ReqBuilder headers(Headers headers);
    ReqBuilder header(String name, String value);

    Body body();
    ReqBuilder body(Body body);
    ReqBuilder body(Form form);

    Req build();

    static ReqBuilder GET(String uriString) {
        return mk(uriString).method(Method.GET);
    }

    static ReqBuilder POST(String uriString){
        return mk(uriString).method(Method.POST);
    }

    static ReqBuilder mk(String uriString) {
        return GET(Url.parse(uriString));
    }

    static ReqBuilder GET(Url uri) {
        return mk(uri).method(Method.GET);
    }

    static ReqBuilder PUT(String uriString) {
        return mk(uriString).method(Method.PUT);
    }

    static ReqBuilder mk(Url uri) {
        return new ReqBuilderImpl(
            Val.NULL("uri", uri).get()
        );
    }
}