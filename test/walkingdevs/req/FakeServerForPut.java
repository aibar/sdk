package walkingdevs.req;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

/**
 * Created by olzhas on 12.03.17.
 */
public class FakeServerForPut extends NanoHTTPD {
    public FakeServerForPut() {
        super(5675);
        try {
            start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
            System.out.println(
                "Fake server for put req started. Happy testing."
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Response serve(IHTTPSession session) {
        return newFixedLengthResponse(session.getMethod().name());
    }
}
