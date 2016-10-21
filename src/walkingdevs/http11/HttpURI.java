package walkingdevs.http11;

import walkingdevs.Val;
import walkingdevs.str.Str;

import java.net.URI;

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

    static HttpURI parse(String uriString) {
        URI uri = URI.create(Val.isBlank(uriString, "uriString").getOrFail());
        HttpURI httpURI = mk();
        httpURI.scheme(Scheme.from(uri.getScheme()));
        httpURI.host(uri.getHost());
        if (uri.getPort() == -1) {
            if (httpURI.scheme() == Scheme.Http) {
                httpURI.port(80);
            } else {
                httpURI.port(443);
            }
        } else {
            httpURI.port(uri.getPort());
        }
        if (Str.mk(uri.getPath()).isBlank()) {
            httpURI.path("/");
        } else {
            httpURI.path(uri.getPath());
        }
        if (Str.mk(uri.getQuery()).isBlank()) {
            httpURI.query(HttpQuery.mk());
        } else {
            httpURI.query(HttpQuery.mk(uri.getQuery()));
        }
        return httpURI;
    }

    // "Dev"
    static HttpURI mk() {
        return mk("localhost", 8080);
    }

    static HttpURI mk(String host) {
        return mk(host, 80);
    }

    static HttpURI mk(String host, int port) {
        return mk(host, port, Scheme.Http);
    }

    static HttpURI mk(String host, int port, Scheme scheme) {
        return new HttpURIImpl(host, port, scheme);
    }
}