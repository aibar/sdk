package walkingdevs.fun;

public interface Function<Result, Argument> {
    Result run(Argument argument);
}