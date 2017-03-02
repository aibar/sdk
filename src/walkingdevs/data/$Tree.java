package walkingdevs.data;

import walkingdevs.val.$Val;
import walkingdevs.val.Val;

/**
 * Created by olzhas on 28.02.17.
 */
public class $Tree {
    public static <K, V> Tree<K, V> mk(K key, V val, Tree<K, V> parent) {
        $Val.mk(
                "val", val,
                (v) -> parent != null && !parent.has(key),
                "Parent tree hasn't have this val"
        ).crash();
        return new TreeImpl<K, V>(
                $Val.NULL("key", key).get(),
                val,
                parent
        );
    }

    public static <K, V> Tree<K, V> mk(K key, V val) {
        return mk(key, val, null);
    }

    public static <K, V> Tree<K, V> mk(K key) {
        return mk(key, null, null);
    }

    public static <K, V> Tree<K, V> copy(Tree<K, V> tree) {
        return copy(tree, null);
    }

    public static <K, V> Tree<K, V> copy(Tree<K, V> tree, Tree<K, V> parent) {
        $Val.NULL("tree", tree).crash();
        Tree<K, V> copy = $Tree.mk(tree.key(), tree.val(), parent);
        for (Tree<K, V> child : tree) {
            copy.add(child);
        }
        return copy;
    }
}
