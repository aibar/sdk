package walkingdevs.data;

public interface Path<Item> {
    Path<Item> add(Item item);

    Path<Item> add(Path<Item> other);

    Item head();

    Item last();

    Path<Item> parent();

    Path<Item> tail();

    // Delimit with "/"
    String string();

    String string(char delimiter);

    Iterable<Item> items();

    int depth();

    boolean isRoot();
}