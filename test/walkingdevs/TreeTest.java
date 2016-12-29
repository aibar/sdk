package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.data.Path;
import walkingdevs.data.Tree;

public class TreeTest extends Assert {
    @Test
    public void shouldGet() {
        assertEquals(
            "1",
            Tree.mk("0").add(
                Tree.mk("1")
            ).get("1").val()
        );

    }

    @Test
    public void shouldWalk() {
        // TODO: composer or builder...
        Tree<String> tree = Tree.mk("0")
            .add(Tree.mk("1")
                .add("11"))
            .add(Tree.mk("2")
                .add("21")
                .add(Tree.mk("22")
                    .add("221")
                    .add("222")
                )
            );
        assertEquals(
            "222",
            tree.walk(Path.mk("/0/2/22/222/Stop!")).val()
        );
        assertEquals(
            "221",
            tree.walk(Path.mk("/0/2/22/221")).val()
        );
        assertEquals(
            "0",
            tree.walk(Path.mk("/0")).val()
        );
    }
}