package walkingdevs.data;

import java.util.Iterator;

class TreeImpl<K, V> implements Tree<K, V> {
    public K key() {
        return key;
    }

    public V val() {
        return val;
    }

    public int size() {
        return nodes.size();
    }

    public Tree<K, V> get(K val) {
        return nodes.get(val);
    }

    public boolean has(K val) {
        return nodes.has(val);
    }

    public Tree<K, V> parent() {
        return parent;
    }

    public Tree<K, V> parent(Tree<K, V> parent) {
        this.parent = parent;
        return this;
    }

    public Tree<K, V> add(Tree<K, V> child) {
        // TODO: Not good, refactor
        nodes.put(
            child.key(),
            child
        );
        child.parent(this);
        return this;
    }

    public Tree<K, V> add(K key, V val) {
        return add(Tree.mk(
            key,
            val
        ));
    }

    public Tree<K, V> add(K key) {
        return add(key, null);
    }

    public Tree<K, V> addToPath(Path<K> path, V val) {
        Tree<K, V> mk = mkPath(path.parent());
        mk.add(path.last(), val);
        return this;
    }

    public Tree<K, V> del(K key) {
        nodes.del(key);
        return this;
    }

    public Tree<K, V> walk(Path<K> path) {
        if (path == null || !key().equals(path.head())) {
            return null;
        } else if (path.depth() == 1) {
            return this;
        }
        Path<K> tail = path.tail();
        if (has(tail.head())) {
            return get(tail.head()).walk(tail);
        }
        return this;
    }

    public Tree<K, V> mkPath(Path<K> path) {
        if (path == null) {
            return this;
        }
        Tree<K, V> parent = this;
        Tree<K, V> walk = walk(path);
        if (walk == null) {
            walk = Tree.mk(path.head(), null);
            parent.add(walk);
            parent = walk;
        }
        for (K k : path.tail().items()) {
            walk = Tree.mk(k, null);
            parent.add(walk);
            parent = walk;
        }
        return walk;
    }

    @Override
    public Iterator<Tree<K, V>> iterator() {
        return nodes.vals().iterator();
    }

    TreeImpl(K key, V val, Tree<K, V> parent) {
        this.key = key;
        this.val = val;
        this.parent = parent;
    }

    private final K key;
    private final V val;
    private Tree<K, V> parent;

    private final Kvs<K, Tree<K, V>> nodes = Kvs.mk();
}