package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.Bytes;
import walkingdevs.bytes.BytesBuilder;
import walkingdevs.stream.BufferedIs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BufferedIsTest extends Assert {
    @Test
    public void shouldIterate() {
        byte[] expected = {1,2,3};
        BytesBuilder actual = BytesBuilder.mk();
        for (byte[] bytes : BufferedIs.mk(new ByteArrayInputStream(expected), 1)) {
            actual.add(bytes);
        }
        assertEquals(
                Bytes.mk(expected),
                Bytes.mk(actual.get())
        );
    }

    @Test
    public void shouldWritesFullyToOutputStream() throws IOException {
        byte[] expected = {1,2,3};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedIs.mk(new ByteArrayInputStream(expected), 1).writeTo(os);
        assertEquals(
                Bytes.mk(expected),
                Bytes.mk(os.toByteArray())
        );
    }

    @Test
    public void shouldMkEmptyIfInputStreamIsNull() {
        assertTrue(
                BufferedIs.mk(null, 1).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNoData() {
        assertTrue(
                BufferedIs.mk(new ByteArrayInputStream(new byte[0]), 1).isEmpty()
        );
    }

    @Test
    public void shouldNotMkEmptyIfDataExists() {
        assertFalse(
                BufferedIs.mk(new ByteArrayInputStream(new byte[1]), 1).isEmpty()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotMkIfSizeIsLessThan1() {
        BufferedIs.mk(new ByteArrayInputStream(new byte[1]), 0);
    }
}