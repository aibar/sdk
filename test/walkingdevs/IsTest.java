package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.Bytes;
import walkingdevs.stream.Is;

import java.io.ByteArrayInputStream;

public class IsTest extends Assert {
    @Test
    public void shouldGetBytes() {
        byte[] expected = {1,2,3};
        assertEquals(
                Bytes.mk(expected),
                Bytes.mk(
                        Is.mk(new ByteArrayInputStream(expected)).bytes()
                )
        );
    }

    @Test
    public void shouldNotMkEmptyIfDataExists() {
        assertFalse(
                Is.mk(
                        new ByteArrayInputStream(new byte[1])
                ).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNoData() {
        assertTrue(
                Is.mk(
                        new ByteArrayInputStream(new byte[0])
                ).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNullPassed() {
        assertTrue(
                Is.mk(null).isEmpty()
        );
    }
}