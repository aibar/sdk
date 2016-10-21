package walkingdevs;

class ValImpl<T> implements Val<T> {
    public void fail() {
        if (result) {
            throw Problems.illegalArg(
                    String.format(FORMAT, name, value, problem)
            );
        }
    }

    public T getOrFail() {
        fail();
        return value;
    }

    ValImpl(T value, String name, boolean result, String problem) {
        this.value = value;
        this.name = name;
        this.result = result;
        this.problem = problem;
    }

    private final T value;
    private final String name;
    private final boolean result;
    private final String problem;
}