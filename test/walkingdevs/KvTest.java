package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.Kv;

public class KvTest extends Assert {
    @Test
    public void shouldGetKey() {
        assertEquals(
            "key",
            Kv.mk("key", "val").key()
        );
    }

    @Test
    public void shouldGetVal() {
        assertEquals(
            "val",
            Kv.mk("key", "val").val()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNullKeys() {
        Kv.mk(null, "How?");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowBlankKeys() {
        Kv.mk(" ", "What?");
    }
}