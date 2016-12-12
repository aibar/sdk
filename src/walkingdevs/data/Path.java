package walkingdevs.data;

import walkingdevs.NULLSafe;

public interface Path<Item> extends NULLSafe {
    Path<Item> add(Item item);

    Item head();

    Item last();

    Path<Item> root();

    Path<Item> parent();

    Path<Item> tail();

    // Delimit with "/"
    String string();

    String string(char delimiter);

    Iterable<Item> items();
}