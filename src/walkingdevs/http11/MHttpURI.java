package walkingdevs.http11;

import walkingdevs.str.MStr;
import walkingdevs.val.MVal;

import java.net.URI;

public class MHttpURI {
    public static HttpURI parse(String uriString) {
        URI uri = URI.create(MVal.mkIsBlank(uriString, "uriString").get());
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
        if (MStr.mk(uri.getPath()).isBlank()) {
            httpURI.path("/");
        } else {
            httpURI.path(uri.getPath());
        }
        if (MStr.mk(uri.getQuery()).isBlank()) {
            httpURI.query(MHttpQuery.mk());
        } else {
            httpURI.query(MHttpQuery.mk(uri.getQuery()));
        }
        return httpURI;
    }

    // "Dev"
    public static HttpURI mk() {
        return mk("localhost", 8080);
    }

    public static HttpURI mk(String host) {
        return mk(host, 80);
    }

    public static HttpURI mk(String host, int port) {
        return mk(host, port, Scheme.Http);
    }

    public static HttpURI mkSsl(String host) {
        return new HttpURIImpl(host, 443, Scheme.Https);
    }

    public static HttpURI mk(String host, int port, Scheme scheme) {
        return new HttpURIImpl(host, port, scheme);
    }
}