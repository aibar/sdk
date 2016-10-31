package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.http11.MHttpQuery;

public class HttpQueryTest extends Assert {
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseNullQueryString() {
        String nil = null;
        MHttpQuery.mk(nil);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseEmptyQueryString() {
        MHttpQuery.mk("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseBlankQueryString() {
        MHttpQuery.mk(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseQueryStringStartingWithQuestionMark() {
        MHttpQuery.mk("?one=1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseQueryStringEndingWithNumberMark() {
        MHttpQuery.mk("one=1#");
    }

    @Test
    public void shouldParseQueryString() {
        String query = "one=1&two=2";
        String expected = "?one=1&two=2";
        assertEquals(
            expected,
            MHttpQuery.mk(query).queryString()
        );
    }

    @Test
    public void shouldParseQueryStringWithEmptyVals() {
        String query = "one=&two&five=5&";
        String expected = "?one=&two=&five=5";
        assertEquals(
            expected,
            MHttpQuery.mk(query).queryString()
        );
    }
}