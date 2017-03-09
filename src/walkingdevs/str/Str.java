package walkingdevs.str;

import walkingdevs.chset.Chset;
import walkingdevs.val.Val;

public interface Str extends Iterable<Character> {
    String get();

    boolean isEmpty();

    boolean isBlank();

    // In UTF-8
    byte[] bytes();

    byte[] bytes(Chset chset);
}