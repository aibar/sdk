package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.Kv;
import walkingdevs.exceptions.IllegalArgument;

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

    @Test(expected = IllegalArgument.class)
    public void shouldNotAllowNullKeys() {
        Kv.mk(null, "How?");
    }

    @Test(expected = IllegalArgument.class)
    public void shouldNotAllowBlankKeys() {
        Kv.mk(" ", "What?");
    }

    @Test
    public void shouldToStringWithThisFormat() {
        assertEquals(
            "key=val",
            Kv.mk("key", "val").toString()
        );
    }
}