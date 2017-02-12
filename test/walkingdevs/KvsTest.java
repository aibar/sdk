package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.Kv;
import walkingdevs.data.Kvs;
import walkingdevs.iter.Iter;

public class KvsTest extends Assert {
    @Test
    public void shouldPut() {
        assertTrue(
            Kvs.mk()
                .put("key", "val")
                .has("key")
        );
    }

    @Test
    public void shouldNotPutTwiceWithSameKeyButChange() {
        Kvs<String, String> kvs = Kvs.mk();
        kvs.put(Kv.mk("key", "val"));
        kvs.put(Kv.mk("key", "val-2"));
        assertEquals(
            1,
            kvs.size()
        );
        assertEquals(
            "val-2",
            kvs.get("key")
        );
    }

    @Test
    public void shouldDel() {
        assertFalse(
            Kvs.mk("key", "val")
                .del("key")
                .has("key")
        );
    }

    @Test
    public void shouldHas() {
        assertTrue(
            Kvs.mk("key", "val").has("key")
        );
    }

    @Test
    public void shouldGetByKey() {
        assertEquals(
            "val",
            Kvs.mk("key", "val").get("key")
        );
    }

    @Test
    public void shouldGetSize() {
        assertEquals(
            2,
            Kvs.mk()
                .put("key1", "val1")
                .put("key2", "val2")
                .size()
        );
    }

    @Test
    public void shouldMakeEmpty() {
        assertTrue(Kvs.mk().isEmpty());
    }

    @Test
    public void shouldNotPutNulls() {
        Kvs<String, String> kvs = Kvs.mk(
            Kv.mk("key1", "val1"),
            // Oops
            null,
            Kv.mk("key2", "val2")
        );
        assertEquals(2, kvs.size());
        assertEquals(2, kvs.put(null).size());
    }

    @Test
    public void shouldGetKeys() {
        Kvs<String, String> kvs = Kvs.mk("key1", "val1")
            .put("key2", "val2")
            .put("key3", "val3");
        assertEquals(
            Iter.mk("key1", "key2", "key3"),
            Iter.mk(kvs.keys())
        );
    }

    @Test
    public void shouldGetVals() {
        Kvs<String, String> kvs = Kvs.mk("key1", "val1")
            .put("key2", "val2")
            .put("key3", "val3");
        assertEquals(
            Iter.mk("val1", "val2", "val3"),
            Iter.mk(kvs.vals())
        );
    }

    @Test
    public void shouldToStringWithThisFormat() {
        Kvs<String, String> kvs = Kvs.mk("key1", "val1")
            .put("key2", "val2")
            .put("key3", "val3");
        assertEquals(
            "key1=val1, key2=val2, key3=val3",
            kvs.toString()
        );
    }
}