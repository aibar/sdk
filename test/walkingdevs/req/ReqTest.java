package walkingdevs.req;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.exceptions.Exceptions;
import walkingdevs.http11.*;
import walkingdevs.str.Str;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

// TODO: more tests
public class ReqTest extends Assert {

    @Test
    public void shouldPutBody(){
        new FakeServerForPut();
        Resp resp = ReqBuilder.PUT("http://localhost:5675")
            .body(Body.mk("test"))
            .build()
            .send();
        assertEquals(Method.PUT.name(), resp.body().text());
    }

    @Test
    public void shouldSendBody() {
        new FakeServer();
        RespBody body = ReqBuilder.POST("http://localhost:5674/shouldSendBody")
            .body(Body.mk("test"))
            .build()
            .send()
            .body();
        assertEquals(
            "test",
            body.text()
        );
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