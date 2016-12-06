package walkingdevs.data;

import walkingdevs.val.Val;

import java.util.ArrayList;
import java.util.List;

class PathImpl<Item> implements Path<Item> {
    public Path<Item> add(Item item) {
        items.add(
            Val.isNull(item, "item").get()
        );
        return this;
    }

    public Item last() {
        return items.get(items.size()-1);
    }

    public Path<Item> parent() {
        Path<Item> ret = Path.mk();
        for (int i = 0; i < items.size()-1; i++) {
            ret.add(items.get(i));
        }
        return ret;
    }

    public String string() {
        return string('/');
    }

    @Override
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

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        return string();
    }

    private final List<Item> items = new ArrayList<>();

    // TODO
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // TODO
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}