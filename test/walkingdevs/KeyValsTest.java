package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.KeyVal;
import walkingdevs.data.KeyVals;

public class KeyValsTest extends Assert {
    @Test
    public void shouldAdd() {
        KeyVals<String, String> kvs = KeyVals.mk();
        kvs.add(KeyVal.mk("key", "val"));
        assertTrue(kvs.has("key"));
    }

    @Test
    public void shouldDel() {
        assertFalse(KeyVals.mk(KeyVal.mk("key", "val")).del("key").has("key"));
    }

    @Test
    public void shouldHas() {
        assertTrue(KeyVals.mk(KeyVal.mk("key", "val")).has("key"));
    }

    @Test
    public void shouldGetSize() {
        KeyVals<String, String> kvs = KeyVals.mk();
        kvs.add(KeyVal.mk("key1", "val1"));
        kvs.add(KeyVal.mk("key1", "val1"));
        kvs.add(KeyVal.mk("key2", "val2"));
        assertEquals(2, kvs.size());
    }

    @Test
    public void shouldMkEmpty() {
        assertNotNull(KeyVals.mk());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotMkIfNullPassed() {
        KeyVals.mk(
                KeyVal.mk("key1", "val1"),
                // Oops
                null,
                KeyVal.mk("key2", "val2")
        );
    }
}