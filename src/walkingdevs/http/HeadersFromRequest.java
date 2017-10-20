package walkingdevs.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class HeadersFromRequest extends HeadersImpl {
    int headerSize = 0;
    HeadersFromRequest(InputStream is) {
        stream(is).anyMatch(s -> {
            if(s.indexOf(':')!=-1){
                headerSize =+ s.getBytes().length;
                if(headerSize <= 1024 * 1024){
                    add(s.substring(0, s.indexOf(':')), s.substring(s.indexOf(':')+1).trim());
                }
                else new IllegalArgumentException("Headers size is too big. Limit is 1024Kb");
            }
            else new IllegalArgumentException("Invalid HTTP header format");
            return s.getBytes().length==0;
        });
    }
    private static Stream<String> stream(InputStream is){
        return new BufferedReader(new InputStreamReader(is)).lines();
    }
}