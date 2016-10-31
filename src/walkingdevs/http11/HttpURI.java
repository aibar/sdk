package walkingdevs.http11;

public interface HttpURI {
    String host();
    HttpURI host(String host);

    int port();
    HttpURI port(int port);

    String path();
    HttpURI path(String path);

    HttpQuery query();
    HttpURI query(HttpQuery query);

    Scheme scheme();
    HttpURI scheme(Scheme scheme);

    String full();
}