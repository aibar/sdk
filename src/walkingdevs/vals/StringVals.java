package walkingdevs.vals;

import walkingdevs.fun.Predicate;
import walkingdevs.val.Val;

// Validators for String
public interface StringVals extends Vals<String> {
    StringVals add(String exp, Predicate<String> predicate);

    StringVals add(Val<String> val);

    StringVals cannotBeNULL();

    StringVals cannotBeEmpty();

    StringVals cannotBeBlank();

    StringVals cannotStartWith(String string);

    StringVals cannotEndWith(String string);
}