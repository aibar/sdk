package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.MBytes;
import walkingdevs.bytes.MBytesBuilder;

public class BytesBuilderTest extends Assert {
    @Test
    public void shouldGet() {
        byte[] expected = {1, 2, 3};
        byte[] actual = MBytesBuilder.mk()
            .add(new byte[]{1})
            .add(new byte[]{2})
            .add(new byte[]{3})
            .get();
        assertEquals(
            MBytes.mk(expected),
            MBytes.mk(actual)
        );
    }

    @Test
    public void shouldGetLength() {
        assertEquals(
            3,
            MBytesBuilder.mk().add(new byte[3]).length()
        );
    }

    @Test
    public void shouldBeEmpty() {
        assertTrue(MBytesBuilder.mk().isEmpty());
    }

    @Test
    public void shouldAdd() {
    }

    @Test
    public void shouldMk() {
        assertNotNull(MBytesBuilder.mk());
    }
}