package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.fun.Handler;
import walkingdevs.http11.mReqBuilder;
import walkingdevs.http11.RespBody;
import walkingdevs.str.mStr;
import walkingdevs.stream.BufferedIs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

// TODO: more tests
public class ReqTest extends Assert {
    @Test
    public void shouldCheckThatThereIsNoApocalypse() {
        mReqBuilder.GET("https://google.com")
            .build()
            .send();
    }

    @Test
    public void shouldGetBody() {
        RespBody body = mReqBuilder.GET("https://google.com")
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
        mReqBuilder.GET("https://google.com")
            .build()
            .send(new Handler<BufferedIs>() {
                public void handle(BufferedIs bufferedIs) {
                    try {
                        bufferedIs.writeTo(baos);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        assertTrue(mStr.mk(baos.toByteArray()).get().contains("google"));
    }
}