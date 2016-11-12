package walkingdevs.val;

import walkingdevs.Problems;
import walkingdevs.fun.Result;

class ValImpl<T> implements Val<T> {
    public void fail() {
        if (result.get()) {
            throw Problems.illegalArg(
                String.format(FORMAT, name, value, problem)
            );
        }
    }

    public T get() {
        fail();
        return value;
    }

    ValImpl(T value, String name, Result<Boolean> result, String problem) {
        this.value = value;
        this.name = name;
        this.result = result;
        this.problem = problem;
    }

    private final T value;
    private final String name;
    private final Result<Boolean> result;
    private final String problem;
}