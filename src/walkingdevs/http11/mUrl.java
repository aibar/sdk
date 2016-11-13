package walkingdevs.http11;

import walkingdevs.str.mStr;
import walkingdevs.val.mVal;

import java.net.URI;

public class mUrl {
    public static Url parse(String uriString) {
        URI uri = URI.create(mVal.isIsBlank(uriString, "uriString").get());
        Url httpURI = mk();
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
        if (mStr.mk(uri.getPath()).isBlank()) {
            httpURI.path("/");
        } else {
            httpURI.path(uri.getPath());
        }
        if (mStr.mk(uri.getQuery()).isBlank()) {
            httpURI.query(mQuery.mk());
        } else {
            httpURI.query(mQuery.mk(uri.getQuery()));
        }
        return httpURI;
    }

    // "Dev"
    public static Url mk() {
        return mk("localhost", 8080);
    }

    public static Url mk(String host) {
        return mk(host, 80);
    }

    public static Url mk(String host, int port) {
        return mk(host, port, Scheme.Http);
    }

    public static Url mkSsl(String host) {
        return new UrlImpl(host, 443, Scheme.Https);
    }

    public static Url mk(String host, int port, Scheme scheme) {
        return new UrlImpl(host, port, scheme);
    }
}