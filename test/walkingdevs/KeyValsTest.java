package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.KeyVals;
import walkingdevs.data.MKeyVal;
import walkingdevs.data.MKeyVals;

public class KeyValsTest extends Assert {
    @Test
    public void shouldAdd() {
        KeyVals<String, String> kvs = MKeyVals.mk();
        kvs.add(MKeyVal.mk("key", "val"));
        assertTrue(kvs.has("key"));
    }

    @Test
    public void shouldNotAddWithSameKey() {
        KeyVals<String, String> kvs = MKeyVals.mk();
        kvs.add(MKeyVal.mk("key", "val"));
        kvs.add(MKeyVal.mk("key", "val"));
        assertEquals(1, kvs.size());
    }

    @Test
    public void shouldDel() {
        assertFalse(
                MKeyVals.mk(
                        MKeyVal.mk("key", "val")
                ).del("key").has("key")
        );
    }

    @Test
    public void shouldHas() {
        assertTrue(
                MKeyVals.mk(
                        MKeyVal.mk("key", "val")
                ).has("key")
        );
    }

    @Test
    public void shouldGetSize() {
        assertEquals(
                2,
                MKeyVals.mk(
                        MKeyVal.mk("key1", "val1"),
                        MKeyVal.mk("key2", "val2")
                ).size()
        );
    }

    @Test
    public void shouldMkEmpty() {
        assertTrue(MKeyVals.mk().isEmpty());
    }

    @Test
    public void shouldNotAddNulls() {
        KeyVals<String, String> kvs = MKeyVals.mk(
                MKeyVal.mk("key1", "val1"),
                // Oops
                null,
                MKeyVal.mk("key2", "val2")
        );
        assertEquals(2, kvs.size());
        assertEquals(2, kvs.add(null).size());
    }
}