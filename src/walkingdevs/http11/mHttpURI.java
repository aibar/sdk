package walkingdevs.http11;

import walkingdevs.str.mStr;
import walkingdevs.val.mVal;

import java.net.URI;

public class mHttpURI {
    public static HttpURI parse(String uriString) {
        URI uri = URI.create(mVal.mkIsBlank(uriString, "uriString").get());
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
        if (mStr.mk(uri.getPath()).isBlank()) {
            httpURI.path("/");
        } else {
            httpURI.path(uri.getPath());
        }
        if (mStr.mk(uri.getQuery()).isBlank()) {
            httpURI.query(mHttpQuery.mk());
        } else {
            httpURI.query(mHttpQuery.mk(uri.getQuery()));
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