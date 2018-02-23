package walkingdevs.exceptions;

import walkingdevs.fun.Handler;

public interface TryVoid {
    void Do();

    static TryVoid mk(Checked checked, Handler<Exception> exceptionHandler) {
        return () -> {
            try {
                checked.run();
            } catch (Exception e) {
                exceptionHandler.handle(
                    e
                );
            }
        };
    }

    static TryVoid mk(Checked checked) {
        return mk(
            checked,
            e -> {
                System.out.println(
                    e.getMessage()
                );
            }
        );
    }

    interface Checked {
        void run() throws Exception;
    }
}