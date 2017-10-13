package walkingdevs.http11;

import java.io.InputStream;

public interface Headers extends Iterable<Header> {
    boolean has(String header);

    Header get(String name);

    Headers add(String name, String value);

    Headers del(String name);

    static Headers parseFromRequest(InputStream is) throws Exception {
        String line = Req.check(is);
        Headers headers = mk();
        int idx;
        idx = line.indexOf('\n');
        line = line.substring(idx+1).trim();
        while (!line.equals("")){
            idx = line.indexOf('\n');
            if(idx > 0){
                headers.add(line.substring(0, idx).substring(0, line.indexOf(':')), line.substring(0, idx).substring(line.indexOf(':') + 1 ).trim());
                line = line.substring(idx+1).trim();
            } else {
                headers.add(line.substring(0, line.indexOf(':')), line.substring(line.indexOf(':') + 1).trim());
                break;
            }
        }
        return headers;
    }

    static Headers mk() {
        return new HeadersImpl();
    }

    static Headers mk(Headers other) {
        Headers headers = mk();
        for (Header header : other) {
            headers.add(header.name(), header.value());
        }
        return headers;
    }

    static Headers mk(Header... other) {
        Headers headers = mk();
        for (Header header : other) {
            headers.add(header.name(), header.value());
        }
        return headers;
    }
}