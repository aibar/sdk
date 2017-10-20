import org.junit.Assert;
import org.junit.Test;
import walkingdevs.http.Headers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class HeadersTest extends Assert {
    @Test
    public void shouldParseHeadersFromRequest() {
        Headers headers = Headers.parseFromRequest(
            fakeHttpIs()
        );
        assertEquals(
            true,
            headers.has("Content-Type")
        );
        assertEquals(
            "text/html",
            headers.get("Content-Type").value()
        );
        assertEquals(
            true,
            headers.has("Content-Length")
        );
        assertEquals(
            "13",
            headers.get("Content-Length").value()
        );
    }

    @Test
    public void shouldNotParseHeadersFromInvalidRequest() {
        try {
            Headers.parseFromRequest(
                fakeInvalidHttpIs()
            );
        } catch (Exception e) {
            assertEquals(
                IllegalArgumentException.class,
                e.getClass()
            );
            assertEquals(
                "Invalid HTTP header format",
                e.getMessage()
            );
        }
    }

    @Test
    public void shouldNotParseHeadersFromLargeRequest() {
        try {
            Headers.parseFromRequest(
                fakeLargeHttpIs()
            );
        } catch (Exception e) {
            assertEquals(
                IllegalArgumentException.class,
                e.getClass()
            );
            assertEquals(
                "Headers size is too big. Limit is 1024Kb",
                e.getMessage()
            );
        }
    }

    @Test
    public void shouldParseHeadersFromRequestWith1MbLength() {
        Headers headers = Headers.parseFromRequest(
            fakeHttpIsWithLength1Mb()
        );
        assertEquals(
            true,
            headers.has("Content-Length")
        );
        assertEquals(
            "11",
            headers.get("Content-Length").value()
        );
    }

    private InputStream fakeHttpIs() {
        String sb = "" +
            "Content-Type: text/html\r\n" +
            "Content-Length: 13\r\n\r\n" +
            "Hello, world!";
        return new ByteArrayInputStream(
            sb.getBytes()
        );
    }

    private InputStream fakeInvalidHttpIs() {
        String sb = "" +
            "Content-Type: text/html\r\n" +
            "Content-Length 13\r\n\r\n" +
            "Hello, world!";
        return new ByteArrayInputStream(
            sb.getBytes()
        );
    }

    private InputStream fakeLargeHttpIs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 40960; i++) {
            sb.append(
                "Content-Type: text/html\r\n"
            );
        }
        sb.append(
            "Content-Length: 0\r\n\r\n"
        );
        return new ByteArrayInputStream(
            sb.toString().getBytes()
        );
    }

    private InputStream fakeHttpIsWithLength1Mb() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31998; i++) {
            sb.append(
                "Content-Type: application/json\r\n"
            );
        }
        sb.append(
            "Accept-Type: application/json\r\n"
        );
        sb.append(
            "Content-Length: 11\r\n\r\n"
        );
        sb.append(
            "0123456789a"
        );
        return new ByteArrayInputStream(
            sb.toString().getBytes()
        );
    }
}