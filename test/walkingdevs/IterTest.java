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
    public void shouldMakeEmptyIfNullPassed() {
        ArrayList<String> nil = null;
        assertEquals(
            "",
            Iter.mk(nil).join("doesn't matter")
        );
    }

    @Test
    public void shouldMakeFromArray() {
        assertEquals(
            "one&two",
            Iter.mk("one", "two").join("&")
        );
    }

    @Test
    public void shouldImplementHashCorrectly() {
        List<Integer> list1 = mkTestList(1, 2, 3);
        List<Integer> list2 = mkTestList(1, 2, 3);
        assertEquals(
            Iter.mk(list1).hashCode(),
            Iter.mk(list2).hashCode()
        );
    }

    @Test
    public void shouldImplementEqualsCorrectly() {
        List<Integer> list1 = mkTestList(1, 2, 3);
        List<Integer> list2 = mkTestList(1, 2, 3);
        assertEquals(
            Iter.mk(list1),
            Iter.mk(list2)
        );
        List<Integer> list3 = mkTestList(1, null, 3);
        assertNotEquals(
            Iter.mk(list3),
            Iter.mk(list2)
        );
        List<Integer> list4 = mkTestList(1, null, 3);
        assertEquals(
            Iter.mk(list3),
            Iter.mk(list4)
        );
        List<Integer> list5 = mkTestList(1, 2);
        assertNotEquals(
            Iter.mk(list1),
            Iter.mk(list5)
        );
    }

    private <T> List<T> mkTestList(T... items) {
        List<T> res = new ArrayList<>();
        for (T item : items) {
            res.add(item);
        }
        return res;
    }
}