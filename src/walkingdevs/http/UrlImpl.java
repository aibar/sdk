package walkingdevs.http;

import walkingdevs.val.Val;
import walkingdevs.str.Str;

class UrlImpl implements Url {
    public String host() {
        return host;
    }

    public Url host(String host) {
        this.host = Val.Blank("host", host).get();
        return this;
    }

    public int port() {
        return port;
    }

    public Url port(int port) {
        this.port = Val.OutSide(
            "port", port,
            1, 65535
        ).get();
        return this;
    }

    public String path() {
        return path;
    }

    public Url path(String path) {
        if (Str.mk(path).isBlank()) {
            path = "/";
        }
        this.path = path;
        return this;
    }

    public Query query() {
        return query;
    }

    public Url query(Query query) {
        this.query = Val.NULL("query", query).get();
        return this;
    }

    public Scheme scheme() {
        return scheme;
    }

    public Url scheme(Scheme scheme) {
        this.scheme = Val.NULL("scheme", scheme).get();
        return this;
    }

    public String full() {
        return scheme() + "://" + host() + ":" + port() + path() + query();
    }

    @Override
    public String toString() {
        return full();
    }

    UrlImpl(String host, int port, Scheme scheme) {
        host(host);
        port(port);
        scheme(scheme);
    }

    private String host;
    private int port;
    private Scheme scheme;

    private String path = "/";
    private Query query = Query.mk();
}