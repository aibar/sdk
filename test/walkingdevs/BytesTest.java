package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.MBytes;

public class BytesTest extends Assert {
    @Test
    public void shouldGetCopy() {
        byte[] bytes = {1, 2, 3};
        // Not equal shallow
        assertNotEquals(
            MBytes.mk(bytes).get(),
            MBytes.mk(bytes).get()
        );
        // Deep equal
        assertEquals(
            MBytes.mk(bytes),
            MBytes.mk(bytes)
        );
    }

    @Test
    public void shouldGetLength() {
        byte[] bytes = {1, 2, 3};
        assertEquals(
            3,
            MBytes.mk(bytes).length()
        );
    }

    @Test
    public void shouldImplementHashCorrectly() {
        byte[] bytes = {1, 2, 3};
        assertEquals(
            MBytes.mk(bytes).hashCode(),
            MBytes.mk(bytes).hashCode()
        );
    }

    @Test
    public void shouldImplementEqualsCorrectly() {
        byte[] bytes = {1, 2, 3};
        assertEquals(
            MBytes.mk(bytes),
            MBytes.mk(bytes)
        );
    }

    @Test
    public void shouldNotMkEmptyIfDataExists() {
        assertFalse(
            MBytes.mk(new byte[1]).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfDataNotExists() {
        assertTrue(
            MBytes.mk(new byte[0]).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNullPassed() {
        assertTrue(
            MBytes.mk(null).isEmpty()
        );
    }
}