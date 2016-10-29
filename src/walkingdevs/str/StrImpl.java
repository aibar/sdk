package walkingdevs.str;

import walkingdevs.chset.Chset;

import java.util.Iterator;

class StrImpl implements Str {
    public String get() {
        return str;
    }

    public boolean isEmpty() {
        return str.isEmpty();
    }

    public boolean isBlank() {
        return isEmpty() || str.trim().isEmpty();
    }

    public byte[] bytes() {
        return bytes(Chset.UTF8());
    }

    public byte[] bytes(Chset chset) {
        if (chset == null) {
            return bytes();
        }
        return str.getBytes(chset.get());
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            public boolean hasNext() {
                return i < str.length();
            }

            public Character next() {
                return str.charAt(i++);
            }

            private int i = 0;
        };
    }

    @Override
    public boolean equals(Object o) {
        return str.equals(o);
    }

    @Override
    public int hashCode() {
        return str.hashCode();
    }

    @Override
    public String toString() {
        return str;
    }

    StrImpl(String str) {
        this.str = str;
    }

    private final String str;
}