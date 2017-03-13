package walkingdevs.req;

import fi.iki.elonen.NanoHTTPD;
import walkingdevs.str.Str;

import java.io.IOException;

class FakeServer extends NanoHTTPD {
    FakeServer() {
        super(5674);
        try {
            start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
            System.out.println(
                "Fake server started. Happy testing."
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NanoHTTPD.Response serve(IHTTPSession session) {
        if ("/shouldSendBody".equals(session.getUri())) {
            byte[] bodyBytes = new byte[4];
            try {
                session.getInputStream().read(bodyBytes, 0, 4);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return newFixedLengthResponse(
                Str.mk(bodyBytes).get()
            );
        } 
        return newFixedLengthResponse("404");
    }

    public static void main(String[] args) {
        new FakeServer();
    }
}