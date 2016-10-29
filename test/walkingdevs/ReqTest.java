package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.http11.*;
import walkingdevs.str.Str;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

// TODO: more tests
public class ReqTest extends Assert {
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
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        assertTrue(Str.mk(baos.toByteArray()).get().contains("google"));
    }
}