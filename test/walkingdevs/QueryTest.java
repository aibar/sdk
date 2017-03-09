package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.http11.$Query;
import walkingdevs.exceptions.IllegalArgument;
import walkingdevs.http11.Query;

public class QueryTest extends Assert {
    @Test(expected = IllegalArgument.class)
    public void shouldNotParseNullQueryString() {
        String nil = null;
        $Query.mk(nil);
    }

    @Test(expected = IllegalArgument.class)
    public void shouldNotParseEmptyQueryString() {
        $Query.mk("");
    }

    @Test(expected = IllegalArgument.class)
    public void shouldNotParseBlankQueryString() {
        $Query.mk(" ");
    }

    @Test(expected = IllegalArgument.class)
    public void shouldNotParseQueryStringStartingWithQuestionMark() {
        $Query.mk("?one=1");
    }

    @Test(expected = IllegalArgument.class)
    public void shouldNotParseQueryStringEndingWithNumberMark() {
        $Query.mk("one=1#");
    }

    @Test
    public void shouldParseQueryString() {
        String query = "one=1&two=2";
        String expected = "?one=1&two=2";
        assertEquals(
            expected,
            $Query.mk(query).queryString()
        );
    }

    @Test
    public void shouldParseQueryStringWithEmptyVals() {
        String query = "one=&two&five=5&";
        String expected = "?one=&two=&five=5";
        assertEquals(
            expected,
            $Query.mk(query).queryString()
        );
    }
}