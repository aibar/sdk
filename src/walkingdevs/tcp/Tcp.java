package walkingdevs.tcp;

import walkingdevs.exceptions.Try;
import walkingdevs.fun.Action;
import walkingdevs.fun.Handler;
import walkingdevs.http11.Host;
import walkingdevs.http11.Port;
import walkingdevs.str.Str;
import walkingdevs.stream.BufferedIs;

import java.net.Socket;

public interface Tcp {
    interface Server {
        void start();

        void kill();

        interface Builder {
            Builder handler(Handler<Socket> socketHandler);

            Builder host(Host host);

            Builder port(Port port);

            Builder success(Action action);

            Builder await(boolean await);

            Server build();
        }
    }

    interface Client {
        Client write(String data);

        interface Builder {
            Builder host(Host host);

            Builder port(Port port);

            Client build();

            default void build(Handler<Client> clientHandler) {
                clientHandler.handle(
                    build()
                );
            }
        }
    }

    static Server.Builder server() {
        return new TcpServerBuilderImpl()
            .host(Host.all())
            .port(Port.mk(4000))
            .await(true)
            .handler(socket -> {
                Try.mk(() -> {
                    socket.getOutputStream().write(
                        "Hello.\n".getBytes()
                    );
                    for (byte[] bytes : BufferedIs.mk(socket.getInputStream(), 1024)) {
                        System.out.println(
                            Str.mk(bytes)
                        );
                    }
                    return Void.TYPE;
                });
            })
            .success(() -> {
                // Do nothing
            });
    }

    static Client.Builder client() {
        return new TcpClientBuilderImpl()
            .host(Host.local())
            .port(Port.mk(4000));
    }
}