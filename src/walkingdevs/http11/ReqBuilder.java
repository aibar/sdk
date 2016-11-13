package walkingdevs.http11;

public interface ReqBuilder {
    int readTimeout();
    ReqBuilder readTimeout(int milliseconds);

    int connectTimeout();
    ReqBuilder connectTimeout(int milliseconds);

    HttpURI uri();

    Method method();
    ReqBuilder method(Method method);

    Headers headers();
    ReqBuilder headers(Headers headers);
    ReqBuilder addHeader(String name, String value);

    Body body();
    ReqBuilder body(Body body);
    ReqBuilder body(Form form);

    Req build();
}