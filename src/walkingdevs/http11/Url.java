package walkingdevs.http11;

import walkingdevs.val.Val;
import walkingdevs.str.Str;

import java.net.URI;

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

    static Url parse(String uriString) {
        URI uri = URI.create(Val.isBlank(uriString, "uriString").get());
        Url url = mk();
        url.scheme(Scheme.from(uri.getScheme()));
        url.host(uri.getHost());
        if (uri.getPort() == -1) {
            if (url.scheme() == Scheme.Http) {
                url.port(80);
            } else {
                url.port(443);
            }
        } else {
            url.port(uri.getPort());
        }
        if (Str.mk(uri.getPath()).isBlank()) {
            url.path("/");
        } else {
            url.path(uri.getPath());
        }
        if (Str.mk(uri.getQuery()).isBlank()) {
            url.query(Query.mk());
        } else {
            url.query(Query.mk(uri.getQuery()));
        }
        return url;
    }

    // "Dev"
    static Url mk() {
        return mk("localhost", 8080);
    }

    static Url mk(String host) {
        return mk(host, 80);
    }

    static Url mk(String host, int port) {
        return mk(host, port, Scheme.Http);
    }

    static Url mkSsl(String host) {
        return new UrlImpl(host, 443, Scheme.Https);
    }

    static Url mk(String host, int port, Scheme scheme) {
        return new UrlImpl(host, port, scheme);
    }
}