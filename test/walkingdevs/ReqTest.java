package walkingdevs;

import fi.iki.elonen.NanoHTTPD;
import org.junit.Assert;
import org.junit.Test;
import walkingdevs.chset.Chset;
import walkingdevs.exceptions.Exceptions;
import walkingdevs.http11.*;
import walkingdevs.str.Str;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// TODO: more tests
public class ReqTest extends Assert {

    static class App extends NanoHTTPD {

        public App() throws IOException {
            super(8081);
            start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
            System.out.println("nRunning! Point your browsers to http://localhost:8081/ \\n");
        }

        @Override
        public Response serve(IHTTPSession session) {

            Map <String, String> map = new HashMap<String, String>();
            Method method = session.getMethod();
            if (Method.PUT.equals(method) || Method.POST.equals(method)) {
                try {
                    session.parseBody(map);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } catch (ResponseException re) {
                    re.printStackTrace();
                }
            }
            return newFixedLengthResponse(map.get("postData"));
        }
    }

    @Test
    public void bodyIsSending(){
        try {
            new App();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RespBody respBody = ReqBuilder.POST("http://localhost:8081").body(Body.mk("test"))
                .build().send().body();
        assertTrue(respBody.text().contains("test"));
    }

    @Test
    public void shouldCheckThatThereIsNoApocalypse() {
        ReqBuilder.GET("https://google.com")
            .build()
            .send();
    }

    @Test
    public void shouldGetBody() {
        RespBody body = ReqBuilder.GET("https://google.com")
            .build()
            .send()
            .body();
        assertTrue(
            body.text().contains("google")
        );
    }

    @Test
    public void shouldGetLargeBody() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ReqBuilder.GET("https://google.com")
            .build()
            .send(bufferedIs -> {
                try {
                    bufferedIs.writeTo(baos);
                } catch (IOException fail) {
                    throw Exceptions.weFucked(fail);
                }
            });
        assertTrue(Str.mk(baos.toByteArray()).get().contains("google"));
    }

    // TODO
    @Test
    public void shouldGetAllData() {
    }
}