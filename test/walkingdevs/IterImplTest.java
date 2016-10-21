package walkingdevs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IterImplTest extends Assert {
    @Test
    public void shouldJoin() {
        String expected = "one&two";
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        assertTrue(Iter.mk(list)
                .join("&")
                .equals(expected)
        );
    }
}