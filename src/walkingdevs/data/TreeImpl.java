package walkingdevs.data;

import walkingdevs.Problems;
import walkingdevs.val.Val;

import java.util.Iterator;

class TreeImpl<T> implements Tree<T> {
    public T val() {
        return value;
    }

    public Tree<T> get(T val) {
        return nodes.get(val);
    }

    public boolean has(T val) {
        return nodes.has(val);
    }

    public Tree<T> parent() {
        return parent;
    }

    public Tree<T> parent(Tree<T> parent) {
        if (parent() != null && !parent().equals(parent)) {
            throw Problems.illegalArg("Child tree is part of another tree");
        }
        this.parent = parent;
        return this;
    }

    public Tree<T> add(T val) {
        add(Tree.mk(val));
        return this;
    }

    public Tree<T> add(Tree<T> child) {
        Val.isNull(child, "child").fail();
        nodes.add(Kv.mk(
            child.val(),
            child
        ));
        child.parent(this);
        return this;
    }

    public Tree<T> del(T val) {
        nodes.del(val);
        return this;
    }

    public Tree<T> walk(Path<T> path) {
        if (path == null || !val().equals(path.head())) {
            return null;
        } else if (path.isAlone()) {
            return this;
        }
        Path<T> tail = path.tail();
        if (has(tail.head())) {
            return get(tail.head()).walk(tail);
        }
        return this;
    }

    @Override
    public Iterator<Tree<T>> iterator() {
        return nodes.vals().iterator();
    }

    TreeImpl(T value, Tree<T> parent) {
        this.value = value;
        this.parent = parent;
    }

    private final T value;
    private final Kvs<T, Tree<T>> nodes = Kvs.mk();

    private Tree<T> parent;
}