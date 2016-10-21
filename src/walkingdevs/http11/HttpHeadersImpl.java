package walkingdevs.http11;

import java.util.*;

class HttpHeadersImpl implements HttpHeaders {
    public boolean has(String header) {
        return map.containsKey(header);
    }

    public HttpHeaders add(String name, String value) {
        map.put(name, value);
        return this;
    }

    public HttpHeaders del(String name) {
        map.remove(name);
        return this;
    }

    public Iterator<HttpHeader> iterator() {
        List<HttpHeader> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(HttpHeader.mk(entry.getKey(), entry.getValue()));
        }
        return list.iterator();
    }

    private final Map<String, String> map = new HashMap<>();
}