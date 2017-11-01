package walkingdevs.http;

import walkingdevs.fun.Function;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
    public ClientHandler(Function<HttpResponse, HttpRequest> handler, Socket client) {
        this.handler = handler;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            handler.run(HttpRequest.mk()).writeFormattedTo(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Function<HttpResponse, HttpRequest> handler;
    Socket client;
}
