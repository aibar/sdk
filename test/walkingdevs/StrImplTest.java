package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.str.Str;

public class StrImplTest extends Assert {
    @Test
    public void shouldGet() {
        assertEquals("Don't get me", Str.mk("Don't get me").get());
    }

    @Test
    public void shouldBeEmpty() {
        assertTrue(Str.mk(null).isEmpty());
        assertTrue(Str.mk("").isEmpty());
    }

    @Test
    public void shouldNotBeEmpty() {
        assertTrue(!Str.mk("not empty").isEmpty());
        assertTrue(!Str.mk(" ").isEmpty());
    }

    @Test
    public void shouldBeBlank() {
        assertTrue(Str.mk(null).isBlank());
        assertTrue(Str.mk("").isBlank());
        assertTrue(Str.mk(" ").isBlank());
        assertTrue(Str.mk(" ").isBlank());
    }

    @Test
    public void shouldNotBeBlank() {
        assertTrue(!Str.mk("not blank").isBlank());
    }

    @Test
    public void shouldIterate() {
        String expected = "I am a very good Expected in Java";
        String actual = "";
        for (Character character : Str.mk(expected)) {
            actual += character;
        }
        assertTrue(expected.equals(actual));
    }
}