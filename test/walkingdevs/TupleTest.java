package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.Tuple;

// Just for 100% coverage!
public class TupleTest extends Assert {
    @Test
    public void shouldGetFirst() {
        assertEquals(
            "first",
            Tuple.mk("first", "second").first()
        );
    }

    @Test
    public void shouldGetSecond() {
        assertEquals(
            "second",
            Tuple.mk("first", "second").second()
        );
    }
}