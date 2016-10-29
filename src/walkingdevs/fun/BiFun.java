package walkingdevs.fun;

public interface BiFun<Result, Arg1, Arg2> {
    Result run(Arg1 arg, Arg2 arg2);
}