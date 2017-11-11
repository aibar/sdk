import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import walkingdevs.http.Http;
import walkingdevs.http.ReqBuilder;

public class HttpServerTest extends Assert {
    @Before
    public void up(){
        Http.server().build().start();
    }
    @Test
    public void shouldStart() {
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