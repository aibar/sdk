package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.$Path;
import walkingdevs.data.$Tree;
import walkingdevs.data.Path;
import walkingdevs.data.Tree;

public class TreeTest extends Assert {
    @Test
    public void shouldGetByKey() {
        assertEquals(
            "1",
            $Tree.mk("0").add(
                $Tree.mk("1")
            ).get("1").key()
        );

    }

    @Test
    public void shouldWalk() {
        Tree<String, Object> tree = $Tree.mk("0")
            .add($Tree.mk("1")
                .add("11"))
            .add($Tree.mk("2")
                .add("21")
                .add($Tree.mk("22")
                    .add("221")
                    .add("222")
                )
            );
        assertEquals(
            "222",
            tree.walk($Path.mk("/0/2/22/222/Stop!")).key()
        );
        assertEquals(
            "221",
            tree.walk($Path.mk("/0/2/22/221")).key()
        );
        assertEquals(
            "0",
            tree.walk($Path.mk("/0")).key()
        );
        assertEquals(
            null,
            tree.walk($Path.mk("/"))
        );
    }

    @Test
    public void shouldMkTreesFromPath() {
        Tree<String, Object> tree = $Tree.mk("0");
        tree.mkPath($Path.mk("/0/2/22/222"));
        assertEquals(
            "222",
            tree.walk($Path.mk("/0/2/22/222")).key()
        );
    }

    @Test
    public void shouldAddFromPath() {
        Tree<String, Object> tree = $Tree.mk("0");
        tree.addToPath($Path.mk("/0/2/22/222"), "val");
        assertEquals(
            "val",
            tree.walk($Path.mk("/0/2/22/222")).val()
        );
    }
}