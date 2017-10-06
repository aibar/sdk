package walkingdevs.http11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HeadersParserImpl implements HeadersParser {

    public HeadersParserImpl(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = reader.readLine();
        int idx;
        while(!line.equals("")){
            idx = line.indexOf(':');
            if(idx < 0){
                break;
            } else {
                headers.add(line.substring(0, idx).toLowerCase(), line.substring(idx+1).trim());
            }
            line = reader.readLine();
        }
    }

    public Headers get() {
        return headers;
    }

    Headers headers = Headers.mk();
}
