package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.MBytes;
import walkingdevs.stream.MIs;

import java.io.ByteArrayInputStream;

public class IsTest extends Assert {
    @Test
    public void shouldGetBytes() {
        byte[] expected = {1, 2, 3};
        assertEquals(
            MBytes.mk(expected),
            MBytes.mk(
                MIs.mk(new ByteArrayInputStream(expected)).bytes()
            )
        );
    }

    @Test
    public void shouldNotMkEmptyIfDataExists() {
        assertFalse(
            MIs.mk(
                new ByteArrayInputStream(new byte[1])
            ).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNoData() {
        assertTrue(
            MIs.mk(
                new ByteArrayInputStream(new byte[0])
            ).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNullPassed() {
        assertTrue(
            MIs.mk(null).isEmpty()
        );
    }
}