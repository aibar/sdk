package walkingdevs.data;

import walkingdevs.val.Val;

public interface Tree<K, V> extends Iterable<Tree<K, V>> {
    K key();

    V val();

    int size();

    Tree<K, V> get(K key);

    boolean has(K val);

    Tree<K, V> parent();

    // TODO: move to TreeBuilder
    Tree<K, V> parent(Tree<K, V> parent);

    Tree<K, V> add(Tree<K, V> child);

    Tree<K, V> add(K key, V val);

    Tree<K, V> add(K key);

    Tree<K, V> addToPath(Path<K> path, V val);

    Tree<K, V> del(K key);

    // TODO: move to TreeWalker
    Tree<K, V> walk(Path<K> path);

    Tree<K, V> mkPath(Path<K> path);

    static <K, V> Tree<K, V> mk(K key, V val, Tree<K, V> parent) {
        Val.mk(
            "val", val,
            (v) -> parent != null && !parent.has(key),
            "Parent tree hasn't have this val"
        ).crash();
        return new TreeImpl<>(
            Val.NULL("key", key).get(),
            val,
            parent
        );
    }

    static <K, V> Tree<K, V> mk(K key, V val) {
        return mk(key, val, null);
    }

    static <K, V> Tree<K, V> mk(K key) {
        return mk(key, null, null);
    }

    static <K, V> Tree<K, V> copy(Tree<K, V> tree) {
        return copy(tree, null);
    }

    static <K, V> Tree<K, V> copy(Tree<K, V> tree, Tree<K, V> parent) {
        Val.NULL("tree", tree).crash();
        Tree<K, V> copy = Tree.mk(tree.key(), tree.val(), parent);
        for (Tree<K, V> child : tree) {
            copy.add(child);
        }
        return copy;
    }
}