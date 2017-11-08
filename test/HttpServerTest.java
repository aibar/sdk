import org.junit.Assert;
import org.junit.Test;
import walkingdevs.http.Http;
import walkingdevs.http.ReqBuilder;

public class HttpServerTest extends Assert {
    @Test
    public void shouldStart() throws InterruptedException {
        Http.server()
            .success(() -> {
            })
            .build()
            .start();
        Thread.sleep(10000);
        assertEquals(
            "Exo server is up and running.",
            ReqBuilder.GET("http://localhost:8080")
                .build()
                .send()
                .body()
                .text()
        );
    }
}