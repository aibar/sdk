package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.http11.*;

// TODO: more tests
public class RequestTest extends Assert {
    @Test
    public void shouldCheckThatThereIsNoApocalypse() {
        Response response = RequestBuilder.mk(HttpURI.mk("google.com", 443, Scheme.Https))
                .method(HttpMethod.GET)
                .build()
                .send();
        System.out.println(response.status());
        System.out.println(response.statusMsg());
    }
}