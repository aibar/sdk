package walkingdevs.http11;

import walkingdevs.fun.Result;
import walkingdevs.str.$Str;
import walkingdevs.val.$Val;

class UrlImpl implements Url {
    public String host() {
        return host;
    }

    public Url host(String host) {
        this.host = $Val.isIsBlank(host, "host").get();
        return this;
    }

    public int port() {
        return port;
    }

    public Url port(final int port) {
        this.port = $Val.mk(
            port,
            "port",
            new Result<Boolean>() {
                public Boolean get() {
                    return port < 1 || port > 65535;
                }
            },
            "Just Invalid"
        ).get();
        return this;
    }

    public String path() {
        return path;
    }

    public Url path(String path) {
        if ($Str.mk(path).isBlank()) {
            path = "/";
        }
        this.path = path;
        return this;
    }

    public Query query() {
        return query;
    }

    public Url query(Query query) {
        this.query = $Val.isNull(query, "query").get();
        return this;
    }

    public Scheme scheme() {
        return scheme;
    }

    public Url scheme(Scheme scheme) {
        this.scheme = $Val.isNull(scheme, "scheme").get();
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
    private Query query = $Query.mk();
}