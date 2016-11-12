package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.mKv;

public class KvTest extends Assert {
    @Test
    public void shouldGetKey() {
        assertEquals(
            "key",
            mKv.mk("key", "val").key()
        );
    }

    @Test
    public void shouldGetVal() {
        assertEquals(
            "val",
            mKv.mk("key", "val").val()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNullKeys() {
        mKv.mk(null, "How?");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowBlankKeys() {
        mKv.mk(" ", "What?");
    }
}