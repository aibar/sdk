package walkingdevs.http11;

import walkingdevs.Val;
import walkingdevs.str.Str;

class HttpURIImpl implements HttpURI {
    public String host() {
        return host;
    }

    public HttpURI host(String host) {
        this.host = Val.isBlank(host, "host").getOrFail();
        return this;
    }

    public int port() {
        return port;
    }

    public HttpURI port(int port) {
        this.port = Val.mk(
                port,
                "port",
                port < 1 || port > 65535,
                "Just Invalid"
        ).getOrFail();
        return this;
    }

    public String path() {
        return path;
    }

    public HttpURI path(String path) {
        if (Str.mk(path).isBlank()) {
            path = "/";
        }
        this.path = path;
        return this;
    }

    public HttpQuery query() {
        return query;
    }

    public HttpURI query(HttpQuery query) {
        this.query = Val.isNull(query, "query").getOrFail();
        return this;
    }

    public Scheme scheme() {
        return scheme;
    }

    public HttpURI scheme(Scheme scheme) {
        this.scheme = Val.isNull(scheme, "scheme").getOrFail();
        return this;
    }

    public String full() {
        return scheme() + "://" + host() + ":" + port() + path() + query();
    }

    @Override
    public String toString() {
        return full();
    }

    HttpURIImpl(String host, int port, Scheme scheme) {
        host(host);
        port(port);
        scheme(scheme);
    }

    private String host;
    private int port;
    private Scheme scheme;

    private String path = "/";
    private HttpQuery query = HttpQuery.mk();
}