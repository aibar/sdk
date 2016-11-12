package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.iter.Iter;

import java.util.ArrayList;
import java.util.List;

public class IterTest extends Assert {
    @Test
    public void shouldJoin() {
        String expected = "one&two";
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        assertEquals(
            expected,
            Iter.mk(list).join("&")
        );
    }

    @Test
    public void shouldJoinOneElement() {
        String expected = "one-and-only";
        List<String> list = new ArrayList<>();
        list.add("one-and-only");
        assertEquals(
            expected,
            Iter.mk(list).join("doesn't matter")
        );
    }

    @Test
    public void shouldMkEmptyIfNullPassed() {
        assertEquals(
            "",
            Iter.mk(null).join("doesn't matter")
        );
    }
}