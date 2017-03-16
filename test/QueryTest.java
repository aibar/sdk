import org.junit.Assert;
import org.junit.Test;
import walkingdevs.exceptions.IllegalArgument;
import walkingdevs.http11.Query;

public class QueryTest extends Assert {
    @Test(expected = IllegalArgument.class)
    public void shouldNotParseNullQueryString() {
        String nil = null;
        Query.mk(nil);
    }

    @Test(expected = IllegalArgument.class)
    public void shouldNotParseEmptyQueryString() {
        Query.mk("");
    }

    @Test(expected = IllegalArgument.class)
    public void shouldNotParseBlankQueryString() {
        Query.mk(" ");
    }

    @Test(expected = IllegalArgument.class)
    public void shouldNotParseQueryStringStartingWithQuestionMark() {
        Query.mk("?one=1");
    }

    @Test(expected = IllegalArgument.class)
    public void shouldNotParseQueryStringEndingWithNumberMark() {
        Query.mk("one=1#");
    }

    @Test
    public void shouldParseQueryString() {
        assertEquals(
            "?one=1&two=2",
            Query.mk("one=1&two=2").queryString()
        );
    }

    @Test
    public void shouldParseQueryStringWithEmptyVals() {
        assertEquals(
            "?one=&two=&five=5",
            Query.mk("one=&two&five=5&").queryString()
        );
    }
}