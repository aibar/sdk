package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.mBytes;
import walkingdevs.bytes.mBytesBuilder;

public class BytesBuilderTest extends Assert {
    @Test
    public void shouldGet() {
        byte[] expected = {1, 2, 3};
        byte[] actual = mBytesBuilder.mk()
            .add(new byte[]{1})
            .add(new byte[]{2})
            .add(new byte[]{3})
            .get();
        assertEquals(
            mBytes.mk(expected),
            mBytes.mk(actual)
        );
    }

    @Test
    public void shouldGetLength() {
        assertEquals(
            3,
            mBytesBuilder.mk().add(new byte[3]).length()
        );
    }

    @Test
    public void shouldBeEmpty() {
        assertTrue(mBytesBuilder.mk().isEmpty());
    }

    @Test
    public void shouldAdd() {
    }

    @Test
    public void shouldMk() {
        assertNotNull(mBytesBuilder.mk());
    }
}