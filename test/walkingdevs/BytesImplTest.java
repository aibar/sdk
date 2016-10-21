package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.Bytes;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

public class BytesImplTest extends Assert {
    @Test
    public void shouldGetCopy() {
        byte[] bytes = new byte[0];
        assertTrue(
            Bytes.mk(bytes).copy() != Bytes.mk(bytes).copy()
        );
    }

    @Test
    public void shouldGetLength() {
        byte[] bytes = new byte[]{1,2,3};
        assertTrue(
            Bytes.mk(bytes).length() == 3
        );
    }

    @Test
    public void shouldGetTextInUTF8() {
        String text = "Привет, Мир!";
        byte[] bytes = text.getBytes();
        assertTrue(
            Bytes.mk(bytes).text().equals(text)
        );
    }

    @Test
    public void shouldGetTextInOtherCharsets() {
        String text = "Привет, Мир!";
        byte[] bytes = text.getBytes(Charset.forName("KOI8"));
        assertTrue(
            Bytes.mk(bytes).text(Charsets.KOI8).equals(text)
        );
    }

    @Test
    public void shouldIterate() {
        byte[] expected = new byte[]{1,2,3};
        ByteArrayOutputStream actual = new ByteArrayOutputStream();
        for (Byte b : Bytes.mk(expected)) {
            actual.write(b);
        }
        assertTrue(
            Bytes.mk(expected).equals(Bytes.mk(actual.toByteArray()))
        );
    }

    @Test
    public void shouldImplementHashCorrectly() {
        assertTrue(
            Bytes.mk(new byte[]{1,2,3}).hashCode() == Bytes.mk(new byte[]{1,2,3}).hashCode()
        );
    }

    @Test
    public void shouldImplementEqualsCorrectly() {
        assertTrue(
            Bytes.mk(new byte[]{1,2,3}).equals(Bytes.mk(new byte[]{1,2,3}))
        );
    }
}