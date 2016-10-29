package walkingdevs.chset;

import java.nio.charset.Charset;

class ChsetImpl implements Chset {
    public Charset get() {
        return Charset.forName(name);
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    ChsetImpl(String name) {
        this.name = name;
    }

    private final String name;
}