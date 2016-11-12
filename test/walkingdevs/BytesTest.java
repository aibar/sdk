package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.mBytes;

public class BytesTest extends Assert {
    @Test
    public void shouldGetCopy() {
        byte[] bytes = {1, 2, 3};
        // Not equal shallow
        assertNotEquals(
            mBytes.mk(bytes).copy(),
            mBytes.mk(bytes).copy()
        );
        // Deep equal
        assertEquals(
            mBytes.mk(bytes),
            mBytes.mk(bytes)
        );
    }

    @Test
    public void shouldGetLength() {
        byte[] bytes = {1, 2, 3};
        assertEquals(
            3,
            mBytes.mk(bytes).length()
        );
    }

    @Test
    public void shouldImplementHashCorrectly() {
        byte[] bytes = {1, 2, 3};
        assertEquals(
            mBytes.mk(bytes).hashCode(),
            mBytes.mk(bytes).hashCode()
        );
    }

    @Test
    public void shouldImplementEqualsCorrectly() {
        byte[] bytes = {1, 2, 3};
        assertEquals(
            mBytes.mk(bytes),
            mBytes.mk(bytes)
        );
    }

    @Test
    public void shouldNotMkEmptyIfDataExists() {
        assertFalse(
            mBytes.mk(new byte[1]).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfDataNotExists() {
        assertTrue(
            mBytes.mk(new byte[0]).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNullPassed() {
        assertTrue(
            mBytes.mk(null).isEmpty()
        );
    }
}