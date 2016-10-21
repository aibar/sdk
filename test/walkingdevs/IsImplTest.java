package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.Bytes;
import walkingdevs.stream.Is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class IsImplTest  extends Assert {
    @Test
    public void shouldGetBytes() {
        byte[] expected = new byte[]{1,2,3};
        InputStream is = new ByteArrayInputStream(expected);
        assertTrue(
            Is.mk(is).bytes().equals(Bytes.mk(expected))
        );
    }

    @Test
    public void shouldIterate() {
        byte[] expected = new byte[]{1,2,3};
        ByteArrayOutputStream actual = new ByteArrayOutputStream();
        for (Byte b : Is.mk(new ByteArrayInputStream(expected))) {
            actual.write(b);
        }
        assertTrue(
            Bytes.mk(expected).equals(Bytes.mk(actual.toByteArray()))
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotMkIfInputStreamIsNull() {
        Is.mk(null);
    }
}