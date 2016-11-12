package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.mTuple;

// Just for 100% coverage!
public class TupleTest extends Assert {
    @Test
    public void shouldGetFirst() {
        assertEquals(
            "first",
            mTuple.mk("first", "second").first()
        );
    }

    @Test
    public void shouldGetSecond() {
        assertEquals(
            "second",
            mTuple.mk("first", "second").second()
        );
    }
}