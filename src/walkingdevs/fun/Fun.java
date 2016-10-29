package walkingdevs.fun;

public interface Fun<Result, Arg> {
    Result run(Arg arg);
}