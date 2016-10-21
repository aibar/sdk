package walkingdevs.http11;

import walkingdevs.Val;

public interface RequestBuilder {
    int readTimeout();
    RequestBuilder readTimeout(int milliseconds);

    int connectTimeout();
    RequestBuilder connectTimeout(int milliseconds);

    HttpURI uri();

    HttpMethod method();
    RequestBuilder method(HttpMethod method);

    HttpHeaders headers();
    RequestBuilder headers(HttpHeaders headers);

    Body body();
    RequestBuilder body(Body body);

    Request build();

    static RequestBuilder mk(String uriString) {
        return mk(
                HttpURI.parse(uriString)
        );
    }

    static RequestBuilder mk(HttpURI uri) {
        return new RequestBuilderImpl(
                Val.isNull(uri, "uri").getOrFail()
        );
    }
}