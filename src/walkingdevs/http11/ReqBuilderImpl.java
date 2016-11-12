package walkingdevs.http11;

import walkingdevs.val.mVal;

class ReqBuilderImpl implements ReqBuilder {
    public int readTimeout() {
        return readTimeout;
    }

    public ReqBuilder readTimeout(int readTimeout) {
        this.readTimeout = mVal.mkNegative(readTimeout, "readTimeout").get();
        return this;
    }

    public int connectTimeout() {
        return connectTimeout;
    }

    public ReqBuilder connectTimeout(int connectTimeout) {
        this.connectTimeout = mVal.mkNegative(connectTimeout, "connectTimeout").get();
        return this;
    }

    public HttpURI uri() {
        return uri;
    }

    public Method method() {
        return method;
    }

    public ReqBuilder method(Method method) {
        this.method = mVal.mkIsNull(method, "method").get();
        return this;
    }

    public Headers headers() {
        return headers;
    }

    public ReqBuilder headers(Headers headers) {
        this.headers = mVal.mkIsNull(headers, "headers").get();
        return this;
    }

    public Body body() {
        return body;
    }

    public ReqBuilder body(Body body) {
        this.body = mVal.mkIsNull(body, "body").get();
        return this;
    }

    public ReqBuilder body(Form form) {
        return body(mBody.mk(form));
    }

    public Req build() {
        return mReq.mk(
            uri(),
            method(),
            headers(),
            body(),
            readTimeout(),
            connectTimeout()
        );
    }

    ReqBuilderImpl(HttpURI uri) {
        this.uri = uri;
    }

    // 10 minutes
    private static final int Timeout = 60 * 60 * 10;

    private final HttpURI uri;

    private int readTimeout = Timeout;
    private int connectTimeout = Timeout;

    private Method method = Method.GET;
    private Headers headers = mHeaders.mk();
    private Body body = mBody.mk();
}