package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.http11.mHttpQuery;

public class HttpQueryTest extends Assert {
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseNullQueryString() {
        String nil = null;
        mHttpQuery.mk(nil);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseEmptyQueryString() {
        mHttpQuery.mk("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseBlankQueryString() {
        mHttpQuery.mk(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseQueryStringStartingWithQuestionMark() {
        mHttpQuery.mk("?one=1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseQueryStringEndingWithNumberMark() {
        mHttpQuery.mk("one=1#");
    }

    @Test
    public void shouldParseQueryString() {
        String query = "one=1&two=2";
        String expected = "?one=1&two=2";
        assertEquals(
            expected,
            mHttpQuery.mk(query).queryString()
        );
    }

    @Test
    public void shouldParseQueryStringWithEmptyVals() {
        String query = "one=&two&five=5&";
        String expected = "?one=&two=&five=5";
        assertEquals(
            expected,
            mHttpQuery.mk(query).queryString()
        );
    }
}