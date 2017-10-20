package walkingdevs.http;

public interface HttpResponse {
    Status status();

    Headers headers();

    Body body();

    static HttpResponse mk(Status status, Headers headers, Body body) {
        return new HttpResponseImpl(
            status,
            headers,
            body
        );
    }
}