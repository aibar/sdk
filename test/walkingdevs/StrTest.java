package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.mBytes;
import walkingdevs.chset.mChset;
import walkingdevs.str.mStr;

public class StrTest extends Assert {
    @Test
    public void shouldGet() {
        String expected = "Please copy me";
        assertEquals(
            expected,
            mStr.mk(expected).get()
        );
    }

    @Test
    public void shouldBeEmpty() {
        String nil = null;
        assertTrue(mStr.mk(nil).isEmpty());
        assertTrue(mStr.mk("").isEmpty());
    }

    @Test
    public void shouldNotBeEmpty() {
        assertFalse(mStr.mk("not empty").isEmpty());
        assertFalse(mStr.mk(" ").isEmpty());
    }

    @Test
    public void shouldBeBlank() {
        String nil = null;
        assertTrue(mStr.mk(nil).isBlank());
        assertTrue(mStr.mk("").isBlank());
        assertTrue(mStr.mk(" ").isBlank());
        assertTrue(mStr.mk(" ").isBlank());
    }

    @Test
    public void shouldNotBeBlank() {
        assertFalse(mStr.mk("not blank").isBlank());
    }

    @Test
    public void shouldIterate() {
        String expected = "I am a very good Expected in Java";
        String actual = "";
        for (Character character : mStr.mk(expected)) {
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
            mBytes.mk(text.getBytes(mChset.UTF8().get())),
            mBytes.mk(
                mStr.mk(text.getBytes()).bytes()
            )
        );
    }

    @Test
    public void shouldGetOtherCharsetTextBytesToo() {
        byte[] expected = "Привет, Мир!".getBytes(mChset.KOI8R().get());
        assertEquals(
            mBytes.mk(expected),
            mBytes.mk(
                mStr.mk(expected, mChset.KOI8R()).bytes(mChset.KOI8R())
            )
        );
    }
}