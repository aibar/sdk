package walkingdevs.data;

import walkingdevs.Problems;
import walkingdevs.val.Val;

// "Smart" Tree
public interface Tree<T> extends Iterable<Tree<T>> {
    T val();

    Tree<T> get(T val);

    boolean has(T val);

    Tree<T> add(T val);

    Tree<T> add(Tree<T> child);

    Tree<T> del(T val);

    Tree<T> parent();

    Tree<T> parent(Tree<T> parent);

    Tree<T> walk(Path<T> path);

    static <T> Tree<T> mk(T val) {
        return mk(val, null);
    }

    static <T> Tree<T> mk(T val, Tree<T> parent) {
        if (parent != null && !parent.has(val)) {
            throw Problems.illegalArg(
                String.format("Parent tree hasn't have this val: %s", val)
            );
        }
        return new TreeImpl<>(
            Val.isNull(val, "val").get(),
            parent
        );
    }

    static <T> Tree<T> copy(Tree<T> tree) {
        return copy(tree, null);
    }

    static <T> Tree<T> copy(Tree<T> tree, Tree<T> parent) {
        Val.isNull(tree, "tree").fail();
        Tree<T> copy = Tree.mk(tree.val(), parent);
        for (Tree<T> child : tree) {
            copy.add(child);
        }
        return copy;
    }
}