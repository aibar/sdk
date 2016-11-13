package walkingdevs.http11;

public interface Url {
    String host();
    Url host(String host);

    int port();
    Url port(int port);

    String path();
    Url path(String path);

    Query query();
    Url query(Query query);

    Scheme scheme();
    Url scheme(Scheme scheme);

    String full();
}