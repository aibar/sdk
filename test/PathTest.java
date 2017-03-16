import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.Path;
import walkingdevs.iter.Iter;

public class PathTest extends Assert {
    @Test
    public void shouldAdd() {
        assertEquals(
            "/one/two",
            Path.mk()
                .add("one")
                .add("two")
                .string()
        );
    }

    @Test
    public void shouldSkipNullWhenAdding() {
        assertEquals(
            "/one/three",
            Path.mk()
                .add("one")
                .add(null)
                .add("three")
                .string()
        );
    }

    @Test
    public void shouldMergePaths() {
        assertEquals(
            "/one/two/three/four",
            Path.mk("/one/two")
                .add(
                    Path.mk("/three/four")
                )
                .string()
        );
    }

    @Test
    public void shouldGetLast() {
        assertEquals(
            "two",
            Path.mk("/one/two").last()
        );
        assertEquals(
            "root",
            Path.mk("/root").last()
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
    public void shouldGetStringDelimitedWithSlashByDefault() {
        assertEquals(
            "/one/two",
            Path.mk().add("one").add("two").string()
        );
    }

    @Test
    public void shouldGetString() {
        assertEquals(
            "/",
            Path.mk().string()
        );
        assertEquals(
            ">one>two",
            Path.mk().add("one").add("two").string('>')
        );
    }

    @Test
    public void shouldMakeFromString() {
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
    public void tailShouldBeEmpty() {
        assertEquals(
            true,
            Path.mk("/1").tail().isRoot()
        );
    }

    @Test
    public void shouldMakeFromHttpPath() {
        assertEquals(
            "/admin/orders",
            Path.mkFromHttpPath("/admin/orders?finished=false").string()
        );
    }

    @Test
    public void shouldMakeEmptyFromEmpty() {
        assertEquals(
            true,
            Path.mk("").isRoot()
        );
        assertEquals(
            true,
            Path.mkFromHttpPath(null).isRoot()
        );
        Integer nil = null;
        Path<Integer> path = Path.mk(nil);
        assertEquals(
            true,
            path.isRoot()
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

    @Test
    public void shouldBeEmpty() {
        assertTrue(
            Path.mk("/").isRoot()
        );
        assertTrue(
            Path.mk("///").isRoot()
        );
    }
}