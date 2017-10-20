package walkingdevs.http;

import walkingdevs.fun.Action;
import walkingdevs.fun.Function;

public interface Http {
    interface Server {
        void start();

        boolean isAlive();

        void kill();

        interface Builder {
            Builder handler(Function<HttpResponse, HttpRequest> handler);
            Function<HttpResponse, HttpRequest> handler();

            Builder host(Host host);
            Host host();

            Builder port(Port port);
            Port port();

            Builder success(Action action);
            Action success();

            Builder await(boolean await);
            boolean await();

            default Server build() {
                return new Exo(
                    host(),
                    port(),
                    handler(),
                    success(),
                    await()
                );
            }
        }
    }

    static Server.Builder server() {
        return new HttpServerBuilderImpl()
            .host(
                Host.all()
            )
            .port(
                Port.mk(8080)
            )
            .success(() -> {
                // Do nothing
            })
            .handler(req -> HttpResponse.mk(
                Status.ok(),
                Headers.mk(),
                Body.mk("Exo server is up and running.")
            ));
    }
}