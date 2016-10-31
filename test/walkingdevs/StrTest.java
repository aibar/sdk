package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.MBytes;
import walkingdevs.chset.MChset;
import walkingdevs.str.MStr;

public class StrTest extends Assert {
    @Test
    public void shouldGet() {
        String expected = "Please get me";
        assertEquals(
                expected,
                MStr.mk(expected).get()
        );
    }

    @Test
    public void shouldBeEmpty() {
        String nil = null;
        assertTrue(MStr.mk(nil).isEmpty());
        assertTrue(MStr.mk("").isEmpty());
    }

    @Test
    public void shouldNotBeEmpty() {
        assertFalse(MStr.mk("not empty").isEmpty());
        assertFalse(MStr.mk(" ").isEmpty());
    }

    @Test
    public void shouldBeBlank() {
        String nil = null;
        assertTrue(MStr.mk(nil).isBlank());
        assertTrue(MStr.mk("").isBlank());
        assertTrue(MStr.mk(" ").isBlank());
        assertTrue(MStr.mk(" ").isBlank());
    }

    @Test
    public void shouldNotBeBlank() {
        assertFalse(MStr.mk("not blank").isBlank());
    }

    @Test
    public void shouldIterate() {
        String expected = "I am a very good Expected in Java";
        String actual = "";
        for (Character character : MStr.mk(expected)) {
            actual += character;
        }
        assertEquals(
                expected,
                actual
        );
    }

    @Test
    public void shouldGetUTF8TextBytes() {
        String text = "Привет, Мир!";
        assertEquals(
                MBytes.mk(text.getBytes(MChset.UTF8().get())),
                MBytes.mk(
                        MStr.mk(text.getBytes()).bytes()
                )
        );
    }

    @Test
    public void shouldGetOtherCharsetTextBytesToo() {
        byte[] expected = "Привет, Мир!".getBytes(MChset.KOI8R().get());
        assertEquals(
                MBytes.mk(expected),
                MBytes.mk(
                        MStr.mk(expected, MChset.KOI8R()).bytes(MChset.KOI8R())
                )
        );
    }
}