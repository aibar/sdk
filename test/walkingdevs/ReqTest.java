package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.fun.Handler;
import walkingdevs.http11.MReqBuilder;
import walkingdevs.http11.RespBody;
import walkingdevs.str.MStr;
import walkingdevs.stream.BufferedIs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

// TODO: more tests
public class ReqTest extends Assert {
    @Test
    public void shouldCheckThatThereIsNoApocalypse() {
        MReqBuilder.GET("https://google.com")
            .build()
            .send();
    }

    @Test
    public void shouldGetBody() {
        RespBody body = MReqBuilder.GET("https://google.com")
            .build()
            .send()
            .body();
        assertTrue(
            body.text().contains("google")
        );
    }

    @Test
    public void shouldGetLargeBody() {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MReqBuilder.GET("https://google.com")
            .build()
            .send(new Handler<BufferedIs>() {
                @Override
                public void handle(BufferedIs bufferedIs) {
                    try {
                        bufferedIs.writeTo(baos);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        assertTrue(MStr.mk(baos.toByteArray()).get().contains("google"));
    }
}