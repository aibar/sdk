package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.MTuple;

// Just for 100% coverage!
public class TupleTest extends Assert {
    @Test
    public void shouldGetFirst() {
        assertEquals(
            "first",
            MTuple.mk("first", "second").first()
        );
    }

    @Test
    public void shouldGetSecond() {
        assertEquals(
            "second",
            MTuple.mk("first", "second").second()
        );
    }
}