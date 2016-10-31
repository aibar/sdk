package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.BytesBuilder;
import walkingdevs.bytes.MBytes;
import walkingdevs.bytes.MBytesBuilder;
import walkingdevs.stream.MBufferedIs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BufferedIsTest extends Assert {
    @Test
    public void shouldIterate() {
        byte[] expected = {1,2,3};
        BytesBuilder actual = MBytesBuilder.mk();
        for (byte[] bytes : MBufferedIs.mk(new ByteArrayInputStream(expected), 1)) {
            actual.add(bytes);
        }
        assertEquals(
                MBytes.mk(expected),
                MBytes.mk(actual.get())
        );
    }

    @Test
    public void shouldWritesFullyToOutputStream() throws IOException {
        byte[] expected = {1,2,3};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        MBufferedIs.mk(new ByteArrayInputStream(expected), 1).writeTo(os);
        assertEquals(
                MBytes.mk(expected),
                MBytes.mk(os.toByteArray())
        );
    }

    @Test
    public void shouldMkEmptyIfInputStreamIsNull() {
        assertTrue(
                MBufferedIs.mk(null, 1).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNoData() {
        assertTrue(
                MBufferedIs.mk(new ByteArrayInputStream(new byte[0]), 1).isEmpty()
        );
    }

    @Test
    public void shouldNotMkEmptyIfDataExists() {
        assertFalse(
                MBufferedIs.mk(new ByteArrayInputStream(new byte[1]), 1).isEmpty()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotMkIfSizeIsLessThan1() {
        MBufferedIs.mk(new ByteArrayInputStream(new byte[1]), 0);
    }
}