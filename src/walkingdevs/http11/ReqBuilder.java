package walkingdevs.http11;

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

    Req build();
}