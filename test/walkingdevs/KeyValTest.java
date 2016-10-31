package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.MKeyVal;

public class KeyValTest extends Assert {
    @Test
    public void shouldGetKey() {
        assertEquals(
            "key",
            MKeyVal.mk("key", "val").key()
        );
    }

    @Test
    public void shouldGetVal() {
        assertEquals(
            "val",
            MKeyVal.mk("key", "val").val()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNullKeys() {
        MKeyVal.mk(null, "How?");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowBlankKeys() {
        MKeyVal.mk(" ", "What?");
    }
}