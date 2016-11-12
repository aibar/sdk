package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.mBytes;
import walkingdevs.stream.mIs;

import java.io.ByteArrayInputStream;

public class IsTest extends Assert {
    @Test
    public void shouldGetBytes() {
        byte[] expected = {1, 2, 3};
        assertEquals(
            mBytes.mk(expected),
            mBytes.mk(
                mIs.mk(new ByteArrayInputStream(expected)).bytes()
            )
        );
    }

    @Test
    public void shouldNotMkEmptyIfDataExists() {
        assertFalse(
            mIs.mk(
                new ByteArrayInputStream(new byte[1])
            ).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNoData() {
        assertTrue(
            mIs.mk(
                new ByteArrayInputStream(new byte[0])
            ).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNullPassed() {
        assertTrue(
            mIs.mk(null).isEmpty()
        );
    }
}