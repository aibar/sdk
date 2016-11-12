package walkingdevs.http11;

import walkingdevs.fun.Result;
import walkingdevs.str.mStr;
import walkingdevs.val.mVal;

class HttpURIImpl implements HttpURI {
    public String host() {
        return host;
    }

    public HttpURI host(String host) {
        this.host = mVal.mkIsBlank(host, "host").get();
        return this;
    }

    public int port() {
        return port;
    }

    public HttpURI port(final int port) {
        this.port = mVal.mk(
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

    public HttpURI path(String path) {
        if (mStr.mk(path).isBlank()) {
            path = "/";
        }
        this.path = path;
        return this;
    }

    public Query query() {
        return query;
    }

    public HttpURI query(Query query) {
        this.query = mVal.mkIsNull(query, "query").get();
        return this;
    }

    public Scheme scheme() {
        return scheme;
    }

    public HttpURI scheme(Scheme scheme) {
        this.scheme = mVal.mkIsNull(scheme, "scheme").get();
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
    private Query query = mQuery.mk();
}