package walkingdevs.http11;

import java.io.IOException;
import java.io.InputStream;

public interface HeadersParser {

    Headers get();

    static HeadersParser mk(InputStream is) throws IOException {
        return new HeadersParserImpl(is);
    }
}
