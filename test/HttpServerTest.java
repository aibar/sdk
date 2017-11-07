import org.junit.Assert;
import org.junit.Test;
import walkingdevs.http.Http;
import walkingdevs.http.ReqBuilder;
import walkingdevs.http.RespBody;

public class HttpServerTest extends Assert {
    @Test
    public void shouldStart() throws InterruptedException {
        RespBody body = ReqBuilder.GET("http://localhost:8080")
            .build()
            .send()
            .body();
        Thread.sleep(1000);
        Http.server()
            .success(() -> {
                assertEquals(
                    "Exo server is up and running.",
                        body.text()
                );
            })
            .build()
            .start();
    }
}