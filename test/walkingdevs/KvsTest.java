package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.Kv;
import walkingdevs.data.Kvs;

public class KvsTest extends Assert {
    @Test
    public void shouldAdd() {
        Kvs<String, String> kvs = Kvs.mk();
        kvs.add(Kv.mk("key", "val"));
        assertTrue(kvs.has("key"));
    }

    @Test
    public void shouldNotAddWithSameKey() {
        Kvs<String, String> kvs = Kvs.mk();
        kvs.add(Kv.mk("key", "val"));
        kvs.add(Kv.mk("key", "val"));
        assertEquals(1, kvs.size());
    }

    @Test
    public void shouldDel() {
        assertFalse(
            Kvs.mk(
                Kv.mk("key", "val")
            ).del("key").has("key")
        );
    }

    @Test
    public void shouldHas() {
        assertTrue(
            Kvs.mk(
                Kv.mk("key", "val")
            ).has("key")
        );
    }

    @Test
    public void shouldGetByKey() {
        assertEquals(
            Kvs.mk(
                Kv.mk("key", "val")
            ).get("key"),
            "val"
        );
    }

    @Test
    public void shouldGetSize() {
        assertEquals(
            2,
            Kvs.mk(
                Kv.mk("key1", "val1"),
                Kv.mk("key2", "val2")
            ).size()
        );
    }

    @Test
    public void shouldMkEmpty() {
        assertTrue(Kvs.mk().isEmpty());
    }

    @Test
    public void shouldNotAddNulls() {
        Kvs<String, String> kvs = Kvs.mk(
            Kv.mk("key1", "val1"),
            // Oops
            null,
            Kv.mk("key2", "val2")
        );
        assertEquals(2, kvs.size());
        assertEquals(2, kvs.add(null).size());
    }
}