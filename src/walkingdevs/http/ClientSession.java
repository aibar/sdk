package walkingdevs.http;

import walkingdevs.fun.Function;

import java.io.*;
import java.net.Socket;

public class ClientSession implements Runnable {
    public ClientSession(Socket clientSocket, Function<HttpResponse, HttpRequest> handler) {
        this.socket  = clientSocket;
        this.handler = handler;
        try {
            this.in = clientSocket.getInputStream();
            this.out = clientSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private final Socket socket;
    private final Function<HttpResponse, HttpRequest> handler;
    private InputStream in;
    private OutputStream out;
    @Override
    public void run() {
        try {
            String header = readHeader();
            System.out.println(header + "\n");
         /* Получаем из заголовка указатель на интересующий ресурс */
            String url = getURIFromHeader(header);
            System.out.println("Resource: " + url + "\n");
         /* Отправляем содержимое ресурса клиенту */
            handler.run(HttpRequest.mk()).writeFormattedTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private String readHeader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder builder = new StringBuilder();
        String ln;
        while (true) {
            ln = reader.readLine();
            if (ln == null || ln.isEmpty()) {
                break;
            }
            builder.append(ln + System.getProperty("line.separator"));
        }
        return builder.toString();
    }

    private String getURIFromHeader(String header) {
        int from = header.indexOf(" ") + 1;
        int to = header.indexOf(" ", from);
        String uri = header.substring(from, to);
        int paramIndex = uri.indexOf("?");
        if (paramIndex != -1) {
            uri = uri.substring(0, paramIndex);
        }
        return DEFAULT_FILES_DIR + uri;
    }
    private static final String DEFAULT_FILES_DIR = "/www";

}
