package walkingdevs.data;

class TupleImpl<F, S> implements Tuple<F, S> {
    public F first() {
        return first;
    }

    public S second() {
        return second;
    }

    TupleImpl(F first, S second) {
        this.first = first;
        this.second = second;
    }

    private final F first;
    private final S second;
}