package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.KeyVal;

public class KeyValTest extends Assert {
    @Test
    public void shouldGetKey() {
        assertEquals(
                "key",
                KeyVal.mk("key", "val").key()
        );
    }

    @Test
    public void shouldGetVal() {
        assertEquals(
                "val",
                KeyVal.mk("key", "val").val()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNullKeys() {
        KeyVal.mk(null, "How?");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowBlankKeys() {
        KeyVal.mk(" ", "What?");
    }
}