package walkingdevs.http11;

import walkingdevs.val.$Val;

class ReqBuilderImpl implements ReqBuilder {
    public int readTimeout() {
        return readTimeout;
    }

    public ReqBuilder readTimeout(int readTimeout) {
        this.readTimeout = $Val.isNegative(readTimeout, "readTimeout").get();
        return this;
    }

    public int connectTimeout() {
        return connectTimeout;
    }

    public ReqBuilder connectTimeout(int connectTimeout) {
        this.connectTimeout = $Val.isNegative(connectTimeout, "connectTimeout").get();
        return this;
    }

    public Url uri() {
        return uri;
    }

    public Method method() {
        return method;
    }

    public ReqBuilder method(Method method) {
        this.method = $Val.isIsNull(method, "method").get();
        return this;
    }

    public Headers headers() {
        return headers;
    }

    public ReqBuilder headers(Headers headers) {
        this.headers = $Val.isIsNull(headers, "headers").get();
        return this;
    }

    public ReqBuilder header(String name, String value) {
        headers().add(name, value);
        return this;
    }

    public Body body() {
        return body;
    }

    public ReqBuilder body(Body body) {
        this.body = $Val.isIsNull(body, "body").get();
        return this;
    }

    public ReqBuilder body(Form form) {
        return body($Body.mk(form));
    }

    public Req build() {
        return $Req.mk(
            uri(),
            method(),
            headers(),
            body(),
            readTimeout(),
            connectTimeout()
        );
    }

    ReqBuilderImpl(Url uri) {
        this.uri = uri;
    }

    // 10 minutes
    private static final int Timeout = 60 * 60 * 10;

    private final Url uri;

    private int readTimeout = Timeout;
    private int connectTimeout = Timeout;

    private Method method = Method.GET;
    private Headers headers = $Headers.mk();
    private Body body = $Body.mk();
}