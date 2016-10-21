package walkingdevs.http11;

import walkingdevs.Val;

class RequestBuilderImpl implements RequestBuilder {
    public int readTimeout() {
        return readTimeout;
    }

    public RequestBuilder readTimeout(int readTimeout) {
        this.readTimeout = Val.mk(
                readTimeout,
                "readTimeout",
                readTimeout < 0,
                "Cannot be negative"
        ).getOrFail();
        return this;
    }

    public int connectTimeout() {
        return connectTimeout;
    }

    public RequestBuilder connectTimeout(int connectTimeout) {
        this.connectTimeout = Val.mk(
                connectTimeout,
                "connectTimeout",
                connectTimeout < 0,
                "Cannot be negative"
        ).getOrFail();
        return this;
    }

    public HttpURI uri() {
        return uri;
    }

    public HttpMethod method() {
        return method;
    }

    public RequestBuilder method(HttpMethod method) {
        this.method = Val.isNull(method, "method").getOrFail();
        return this;
    }

    public HttpHeaders headers() {
        return headers;
    }

    public RequestBuilder headers(HttpHeaders headers) {
        this.headers = Val.isNull(headers, "headers").getOrFail();
        return this;
    }

    public Body body() {
        return body;
    }

    public RequestBuilder body(Body body) {
        this.body = Val.isNull(body, "body").getOrFail();
        return this;
    }

    public Request build() {
        return Request.mk(
                uri(),
                method(),
                headers(),
                body(),
                readTimeout(),
                connectTimeout()
        );
    }

    RequestBuilderImpl(HttpURI uri) {
        this.uri = uri;
    }

    // 10 minutes
    private static final int Timeout = 60*60*10;

    private final HttpURI uri;

    private int readTimeout = Timeout;
    private int connectTimeout = Timeout;

    private HttpMethod method = HttpMethod.GET;
    private HttpHeaders headers = HttpHeaders.mk();
    private Body body = Body.mkEmpty();
}