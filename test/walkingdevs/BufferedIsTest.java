package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.Bytes;
import walkingdevs.bytes.BytesBuilder;
import walkingdevs.exceptions.IllegalArgument;
import walkingdevs.stream.BufferedIs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BufferedIsTest extends Assert {
    @Test
    public void shouldIterate() {
        byte[] expected = {1, 2, 3};
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
        byte[] expected = {1, 2, 3};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedIs.mk(new ByteArrayInputStream(expected), 1).writeTo(os);
        assertEquals(
            Bytes.mk(expected),
            Bytes.mk(os.toByteArray())
        );
    }

    @Test
    public void shouldMakeEmptyIfInputStreamIsNull() {
        assertTrue(
            BufferedIs.mk(null, 1).isEmpty()
        );
    }

    @Test
    public void shouldMakeEmptyIfNoData() {
        assertTrue(
            BufferedIs.mk(new ByteArrayInputStream(new byte[0]), 1).isEmpty()
        );
    }

    @Test
    public void shouldNotMakeEmptyIfDataExists() {
        assertFalse(
            BufferedIs.mk(new ByteArrayInputStream(new byte[1]), 1).isEmpty()
        );
    }

    @Test(expected = IllegalArgument.class)
    public void shouldNotMakeIfSizeIsLessThan1() {
        BufferedIs.mk(new ByteArrayInputStream(new byte[1]), 0);
    }
}