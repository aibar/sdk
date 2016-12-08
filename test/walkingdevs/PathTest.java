package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.Path;
import walkingdevs.iter.Iter;

public class PathTest extends Assert {
    @Test
    public void shouldAdd() {
        assertEquals(
            "/one/two",
            Path.mk().add("one").add("two").string()
        );
    }

    @Test
    public void shouldGetLast() {
        assertEquals(
            "two",
            Path.mk().add("one").add("two").last()
        );
    }

    @Test
    public void shouldGetParent() {
        assertEquals(
            "/one",
            Path.mk().add("one").add("two").parent().string()
        );
    }

    @Test
    public void shouldGetStringDelimitedWithSlash() {
        assertEquals(
            "/one/two",
            Path.mk().add("one").add("two").string()
        );
    }

    @Test
    public void shouldGetString() {
        assertEquals(
            ">one>two",
            Path.mk().add("one").add("two").string('>')
        );
    }

    @Test
    public void shouldMkFromString() {
        assertEquals(
            "/1/2/3",
            Path.mk("/1/2/3").string()
        );
        assertEquals(
            "/1/2/3",
            Path.mk("///1//2/3//").string()
        );
        assertEquals(
            "/1",
            Path.mk("//1//").string()
        );
        assertEquals(
            "/one/two",
            Path.mk("/one/two").string()
        );
    }

    @Test
    public void shouldGetItems() {
        assertEquals(
            "1,2,3",
            Iter.mk(
                Path.mk("/1/2/3").items()
            ).join(",")
        );
    }

    @Test
    public void shouldGetTail() {
        assertEquals(
            "/2/3",
            Path.mk("/1/2/3").tail().string()
        );
    }

    @Test
    public void shouldMkHttpPath() {
        assertEquals(
            "/admin/orders",
            Path.mkHttp("/admin/orders?finished=false").string()
        );
    }

    @Test
    public void shouldGetHead() {
        assertEquals(
            "one",
            Path.mk().add("one").add("two").head()
        );
    }

    @Test
    public void shouldGetRoot() {
        assertEquals(
            "/one",
            Path.mk("/one/two").root().string()
        );
    }

    @Test
    public void shouldImplEquals() {
        assertEquals(
            Path.mk("/one/two"),
            Path.mk("/one/two")
        );
    }

    @Test
    public void shouldImplHashCode() {
        assertEquals(
            Path.mk("/one/two").hashCode(),
            Path.mk("/one/two").hashCode()
        );
    }
}