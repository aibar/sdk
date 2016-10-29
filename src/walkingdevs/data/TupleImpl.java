package walkingdevs.data;

class TupleImpl<A, B> implements Tuple<A, B> {
    public A first() {
        return first;
    }

    public B second() {
        return second;
    }

    TupleImpl(A first, B second) {
        this.first = first;
        this.second = second;
    }

    private final A first;
    private final B second;
}