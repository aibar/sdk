package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.Kvs;
import walkingdevs.data.mKv;
import walkingdevs.data.mKvs;

public class KvsTest extends Assert {
    @Test
    public void shouldAdd() {
        Kvs<String, String> kvs = mKvs.mk();
        kvs.add(mKv.mk("key", "val"));
        assertTrue(kvs.has("key"));
    }

    @Test
    public void shouldNotAddWithSameKey() {
        Kvs<String, String> kvs = mKvs.mk();
        kvs.add(mKv.mk("key", "val"));
        kvs.add(mKv.mk("key", "val"));
        assertEquals(1, kvs.size());
    }

    @Test
    public void shouldDel() {
        assertFalse(
            mKvs.mk(
                mKv.mk("key", "val")
            ).del("key").has("key")
        );
    }

    @Test
    public void shouldHas() {
        assertTrue(
            mKvs.mk(
                mKv.mk("key", "val")
            ).has("key")
        );
    }

    @Test
    public void shouldGetSize() {
        assertEquals(
            2,
            mKvs.mk(
                mKv.mk("key1", "val1"),
                mKv.mk("key2", "val2")
            ).size()
        );
    }

    @Test
    public void shouldMkEmpty() {
        assertTrue(mKvs.mk().isEmpty());
    }

    @Test
    public void shouldNotAddNulls() {
        Kvs<String, String> kvs = mKvs.mk(
            mKv.mk("key1", "val1"),
            // Oops
            null,
            mKv.mk("key2", "val2")
        );
        assertEquals(2, kvs.size());
        assertEquals(2, kvs.add(null).size());
    }
}