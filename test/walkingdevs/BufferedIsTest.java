package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.Bytes;
import walkingdevs.stream.BufferedIs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedIsTest extends Assert {
    @Test
    public void shouldGetBufferedBytes() {
        byte[] expected = new byte[]{1,2};
        InputStream is = new ByteArrayInputStream(new byte[]{1,2,3});
        BufferedIs bufferedIs = BufferedIs.mk(is, 1);
        bufferedIs.iterator().next();
        bufferedIs.iterator().next();
        assertTrue(
            bufferedIs.bytes().equals(Bytes.mk(expected))
        );
    }

    @Test
    public void shouldIterate() {
        byte[] expected = new byte[]{1,2,3};
        ByteArrayOutputStream actual = new ByteArrayOutputStream();
        for (byte[] bytes : BufferedIs.mk(new ByteArrayInputStream(expected), 1024)) {
            actual.write(bytes, 0, bytes.length);
        }
        assertTrue(
            Bytes.mk(expected).equals(Bytes.mk(actual.toByteArray()))
        );
    }

    @Test
    public void shouldWritesFullyToOutputStream() throws IOException {
        byte[] expected = new byte[]{1,2,3};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedIs.mk(new ByteArrayInputStream(expected), 1).write(os);
        assertEquals(
                Bytes.mk(expected),
                Bytes.mk(os.toByteArray())
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotMkIfInputStreamIsNull() {
        BufferedIs.mk(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotMkIfSizeIsLessThan1() {
        BufferedIs.mk(new ByteArrayInputStream(new byte[1]), 0);
    }
}