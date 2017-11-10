package req;

import java.io.*;
import java.net.Socket;

public class ClientSession implements Runnable{

    @Override
    public void run() {
        try {
            String header = readHeader();
            System.out.println(header + "\n");
         /* Получаем из заголовка указатель на интересующий ресурс */
            String url = getURIFromHeader(header);
            System.out.println("Resource: " + url + "\n");
         /* Отправляем содержимое ресурса клиенту */
            send();
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

    public ClientSession(Socket socket) throws IOException {
        this.socket = socket;
        in = socket.getInputStream();
        out = socket.getOutputStream();
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

    private void send() throws IOException {
        String header = "HTTP1/1 200 OK\n\nExo server is up and running.";
        PrintStream answer = new PrintStream(out, true, "UTF-8");
        answer.print(header);
    }

    private Socket socket;
    private InputStream in = null;
    private OutputStream out = null;

    private static final String DEFAULT_FILES_DIR = "/www";
}
