package req;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    /**
     * Первым аргументом может идти номер порта.
     */
    public static void main(String ... args) {
      /* Если аргументы отсутствуют, порт принимает значение поумолчанию */
        int port = DEFAULT_PORT;
      /* Создаем серверный сокет на полученном порту */
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: "
                + serverSocket.getLocalPort() + "\n");
        } catch (IOException e) {
            System.out.println("Port " + port + " is blocked.");
            System.exit(-1);
        }
      /*
       * Если порт был свободен и сокет был успешно создан, можно переходить к
       * следующему шагу - ожиданию клинтов
       */
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
            /* Для обработки запроса от каждого клиента создается
             * отдельный объект и отдельный поток */
                ClientSession session = new ClientSession(clientSocket);
                Thread t = new Thread(session);
                t.setDaemon(false);
                t.start();
            } catch (IOException e) {
                System.out.println("Failed to establish connection.");
                System.out.println(e.getMessage());
                System.exit(-1);
            }
        }
    }

    private static final int DEFAULT_PORT = 9999;
}

