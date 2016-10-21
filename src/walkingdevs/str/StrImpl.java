package walkingdevs.str;

import java.util.Iterator;

class StrImpl implements Str {
    public String get() {
        return str;
    }

    public boolean isEmpty() {
        return str == null || str.isEmpty();
    }

    public boolean isBlank() {
        return isEmpty() || str.trim().isEmpty();
    }

    @Override
    public Iterator<Character> iterator() {
        return new StrIterator();
    }

    @Override
    public boolean equals(Object o) {
        return str != null && str.equals(o);
    }

    @Override
    public int hashCode() {
        return str != null ? str.hashCode() : 0;
    }

    @Override
    public String toString() {
        // The correct way.
        return str != null ? str : "";
    }

    StrImpl(String str) {
        this.str = str;
    }

    private final String str;

    private class StrIterator implements Iterator<Character> {
        public boolean hasNext() {
            return i < str.length();
        }

        public Character next() {
            return str.charAt(i++);
        }

        private int i = 0;
    }
}