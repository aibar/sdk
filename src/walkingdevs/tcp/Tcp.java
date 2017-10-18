package walkingdevs.tcp;

import walkingdevs.fun.Action;
import walkingdevs.fun.Handler;
import walkingdevs.http11.Host;
import walkingdevs.http11.Port;

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
        return new TcpServerBuilderImpl();
    }

    static Client.Builder client() {
        return new TcpClientBuilderImpl();
    }
}