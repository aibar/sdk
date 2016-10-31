package walkingdevs.val;

public interface Val<T> {
    void fail();

    T get();

    String FORMAT = "Arg. <%s> with value <%s>: %s";

    String BANG = "Null check. BANG.";

    String BLANK = "Cannot be Blank.";
}