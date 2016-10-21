package walkingdevs.fun;

public interface Fun {
    void run();

    static void Try(Fun fun, Handler<Throwable> tHandler) {
        try {
            fun.run();
        } catch (Throwable t) {
            tHandler.handle(t);
        }
    }
}