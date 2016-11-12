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
        byte[] bytes = {1, 2, 3};
        assertEquals(
            Bytes.mk(bytes).hashCode(),
            Bytes.mk(bytes).hashCode()
        );
    }

    @Test
    public void shouldImplementEqualsCorrectly() {
        byte[] bytes = {1, 2, 3};
        assertEquals(
            Bytes.mk(bytes),
            Bytes.mk(bytes)
        );
    }

    @Test
    public void shouldNotMkEmptyIfDataExists() {
        assertFalse(
            Bytes.mk(new byte[1]).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfDataNotExists() {
        assertTrue(
            Bytes.mk(new byte[0]).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNullPassed() {
        assertTrue(
            Bytes.mk(null).isEmpty()
        );
    }
}