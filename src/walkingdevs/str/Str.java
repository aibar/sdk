package walkingdevs.str;

public interface Str extends Iterable<Character> {
    String get();

    boolean isEmpty();

    boolean isBlank();

    static Str mk(String str) {
        return new StrImpl(str);
    }
}