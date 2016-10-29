package walkingdevs.str;

import walkingdevs.chset.Chset;

public interface Str extends Iterable<Character> {
    String get();

    boolean isEmpty();

    boolean isBlank();

    // In UTF-8
    byte[] bytes();

    byte[] bytes(Chset chset);

    // No NULLs!!!
    static Str mk() {
        return mk("");
    }

    static Str mk(String str) {
        if (str == null) {
            return mk();
        }
        return new StrImpl(str);
    }

    // In UTF-8
    static Str mk(byte[] bytes) {
        return mk(bytes, Chset.UTF8());
    }

    static Str mk(byte[] bytes, Chset chset) {
        if (bytes == null || bytes.length == 0) {
            return mk();
        } else if(chset == null) {
            return mk(bytes);
        }
        return mk(new String(bytes, chset.get()));
    }
}