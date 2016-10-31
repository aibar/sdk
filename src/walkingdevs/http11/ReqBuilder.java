package walkingdevs.http11;

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
}