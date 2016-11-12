package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.BytesBuilder;
import walkingdevs.bytes.mBytes;
import walkingdevs.bytes.mBytesBuilder;
import walkingdevs.stream.mBufferedIs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BufferedIsTest extends Assert {
    @Test
    public void shouldIterate() {
        byte[] expected = {1, 2, 3};
        BytesBuilder actual = mBytesBuilder.mk();
        for (byte[] bytes : mBufferedIs.mk(new ByteArrayInputStream(expected), 1)) {
            actual.add(bytes);
        }
        assertEquals(
            mBytes.mk(expected),
            mBytes.mk(actual.get())
        );
    }

    @Test
    public void shouldWritesFullyToOutputStream() throws IOException {
        byte[] expected = {1, 2, 3};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        mBufferedIs.mk(new ByteArrayInputStream(expected), 1).writeTo(os);
        assertEquals(
            mBytes.mk(expected),
            mBytes.mk(os.toByteArray())
        );
    }

    @Test
    public void shouldMkEmptyIfInputStreamIsNull() {
        assertTrue(
            mBufferedIs.mk(null, 1).isEmpty()
        );
    }

    @Test
    public void shouldMkEmptyIfNoData() {
        assertTrue(
            mBufferedIs.mk(new ByteArrayInputStream(new byte[0]), 1).isEmpty()
        );
    }

    @Test
    public void shouldNotMkEmptyIfDataExists() {
        assertFalse(
            mBufferedIs.mk(new ByteArrayInputStream(new byte[1]), 1).isEmpty()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotMkIfSizeIsLessThan1() {
        mBufferedIs.mk(new ByteArrayInputStream(new byte[1]), 0);
    }
}