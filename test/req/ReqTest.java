package req;

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
    public void shouldSendBody() {
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
    public void shouldPutBody(){
        new FakeServer();
        Resp resp = ReqBuilder.PUT("http://localhost:5674/shouldSendBody")
            .body(Body.mk("tets"))
            .build()
            .send();
        assertEquals("tets", resp.body().text());
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