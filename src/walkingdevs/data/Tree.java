package walkingdevs.data;

import walkingdevs.val.Val;

public interface Tree<K, V> extends Iterable<Tree<K, V>> {
    K key();

    V val();

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
}