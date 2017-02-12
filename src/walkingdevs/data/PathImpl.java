package walkingdevs.data;

import walkingdevs.val.Val;

import java.util.ArrayList;
import java.util.List;

class PathImpl<Item> implements Path<Item> {
    public Path<Item> add(Item item) {
        items.add(
            Val.NULL("item", item).get()
        );
        return this;
    }

    public Path<Item> add(Path<Item> other) {
        Path<Item> path = Path.mk();
        for (Item item : items) {
            path.add(item);
        }
        for (Item item : other.items()) {
            path.add(item);
        }
        return path;
    }

    public Item head() {
        if (isRoot()) {
            return null;
        }
        return items.get(0);
    }

    public Item last() {
        if (isRoot()) {
            return null;
        }
        return items.get(items.size()-1);
    }

    public Path<Item> parent() {
        Path<Item> ret = Path.mk();
        for (int i = 0; i < items.size()-1; i++) {
            ret.add(items.get(i));
        }
        return ret;
    }

    public Path<Item> tail() {
        Path<Item> ret = Path.mk();
        for (int i = 1; i < items.size(); i++) {
            ret.add(items.get(i));
        }
        return ret;
    }

    public String string() {
        return string('/');
    }

    public String string(char delimiter) {
        if (items.isEmpty()) {
            return delimiter + "";
        }
        StringBuilder ret = new StringBuilder();
        for (Item item : items) {
            ret.append(delimiter).append(item);
        }
        return ret.toString();
    }

    public Iterable<Item> items() {
        return items;
    }

    public int depth() {
        return items.size();
    }

    public boolean isRoot() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        return string();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Path && toString().equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    private final List<Item> items = new ArrayList<>();
}