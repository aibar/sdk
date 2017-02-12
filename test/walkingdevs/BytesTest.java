package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.Bytes;

public class BytesTest extends Assert {
    @Test
    public void shouldGetCopy() {
        byte[] bytes = {1, 2, 3};
        // Not equal shallow
        assertNotEquals(
            Bytes.mk(bytes).copy(),
            Bytes.mk(bytes).copy()
        );
        // Deep equal
        assertEquals(
            Bytes.mk(bytes),
            Bytes.mk(bytes)
        );
    }

    @Test
    public void shouldGetLength() {
        byte[] bytes = {1, 2, 3};
        assertEquals(
            3,
            Bytes.mk(bytes).length()
        );
    }

    @Test
    public void shouldImplementHashCorrectly() {
        byte[] bytes1 = {1, 2, 3};
        byte[] bytes2 = {1, 2, 3};
        assertEquals(
            Bytes.mk(bytes1).hashCode(),
            Bytes.mk(bytes2).hashCode()
        );
    }

    @Test
    public void shouldImplementEqualsCorrectly() {
        byte[] bytes1 = {1, 2, 3};
        byte[] bytes2 = {1, 2, 3};
        assertEquals(
            Bytes.mk(bytes1),
            Bytes.mk(bytes2)
        );
    }

    @Test
    public void shouldNotMakeEmptyIfDataExists() {
        assertFalse(
            Bytes.mk(new byte[1]).isEmpty()
        );
    }

    @Test
    public void shouldMakeEmptyIfDataNotExists() {
        assertTrue(
            Bytes.mk(new byte[0]).isEmpty()
        );
    }

    @Test
    public void shouldMakeEmptyIfNullPassed() {
        assertTrue(
            Bytes.mk(null).isEmpty()
        );
    }

    @Test
    public void shouldToStringFirst10Bytes() {
        assertEquals(
            "1, 2, 3",
            Bytes.mk(new byte[]{1, 2, 3}).toString()
        );
        assertEquals(
            "1",
            Bytes.mk(new byte[]{1}).toString()
        );
        assertEquals(
            "1, 2, 3, 4, 5, 6, 7, 8, 9, 10",
            Bytes.mk(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}).toString()
        );
        assertEquals(
            "",
            Bytes.mk(new byte[]{}).toString()
        );
        assertEquals(
            "",
            Bytes.mk(null).toString()
        );
    }
}