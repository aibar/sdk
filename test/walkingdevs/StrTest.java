package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.$Bytes;
import walkingdevs.chset.$Chset;
import walkingdevs.str.$Str;

public class StrTest extends Assert {
    @Test
    public void shouldGet() {
        String expected = "Please copy me";
        assertEquals(
            expected,
            $Str.mk(expected).get()
        );
    }

    @Test
    public void shouldBeEmpty() {
        String nil = null;
        assertTrue($Str.mk(nil).isEmpty());
        assertTrue($Str.mk("").isEmpty());
    }

    @Test
    public void shouldNotBeEmpty() {
        assertFalse($Str.mk("not empty").isEmpty());
        assertFalse($Str.mk(" ").isEmpty());
    }

    @Test
    public void shouldBeBlank() {
        String nil = null;
        assertTrue($Str.mk(nil).isBlank());
        assertTrue($Str.mk("").isBlank());
        assertTrue($Str.mk(" ").isBlank());
        assertTrue($Str.mk(" ").isBlank());
    }

    @Test
    public void shouldNotBeBlank() {
        assertFalse($Str.mk("not blank").isBlank());
    }

    @Test
    public void shouldIterate() {
        String expected = "I am a very good Expected in Java";
        String actual = "";
        for (Character character : $Str.mk(expected)) {
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
            $Bytes.mk(text.getBytes($Chset.UTF8().get())),
            $Bytes.mk(
                $Str.mk(text.getBytes()).bytes()
            )
        );
    }

    @Test
    public void shouldGetOtherCharsetTextBytesToo() {
        byte[] expected = "Привет, Мир!".getBytes($Chset.KOI8R().get());
        assertEquals(
            $Bytes.mk(expected),
            $Bytes.mk(
                $Str.mk(expected, $Chset.KOI8R()).bytes($Chset.KOI8R())
            )
        );
    }
}