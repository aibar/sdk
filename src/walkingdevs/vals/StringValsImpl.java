package walkingdevs.vals;

import walkingdevs.fun.Predicate;
import walkingdevs.val.$Val;
import walkingdevs.val.Val;

class StringValsImpl implements StringVals {
    public StringVals cannotBeEmpty() {
        vals.add($Val.Empty(
            name(),
            val()
        ));
        return this;
    }

    public StringVals cannotBeBlank() {
        vals.add($Val.Blank(
            name(),
            val()
        ));
        return this;
    }

    public StringVals cannotStartWith(final String string) {
        vals.add("Can not start with <" + string + ">", new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith(string);
            }
        });
        return this;
    }

    public StringVals cannotEndWith(final String string) {
        vals.add("Can not end with <" + string + ">", new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.endsWith(string);
            }
        });
        return this;
    }

    public void crash() {
        vals.crash();
    }

    public boolean test() {
        return vals.test();
    }

    public String get() {
        return vals.get();
    }

    public String val() {
        return vals.val();
    }

    public String name() {
        return vals.name();
    }

    public StringVals add(String exp, Predicate<String> predicate) {
        vals.add(exp, predicate);
        return this;
    }

    public StringVals add(Val<String> val) {
        vals.add(val);
        return this;
    }

    public StringVals cannotBeNULL() {
        vals.cannotBeNULL();
        return this;
    }

    StringValsImpl(Vals<String> vals) {
        this.vals = vals;
    }

    private final Vals<String> vals;
}