package walkingdevs.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class DefaultAsyncRunner implements AsyncRunner {

    protected long requestCount;

    private final List<ClientHandler> running = Collections.synchronizedList(new ArrayList<ClientHandler>());
    public List<ClientHandler> getRunning() {
        return running;
    }

    @Override
    public void closeAll() {
        // copy of the list for concurrency
        for (ClientHandler clientHandler : new ArrayList<ClientHandler>(this.running)) {
            clientHandler.close();
        }
    }

    @Override
    public void closed(ClientHandler clientHandler) {
        this.running.remove(clientHandler);
    }

    @Override
    public void exec(ClientHandler clientHandler) {
        ++this.requestCount;
        this.running.add(clientHandler);
        createThread(clientHandler).start();
    }

    protected Thread createThread(ClientHandler clientHandler) {
        Thread t = new Thread(clientHandler);
        t.setDaemon(true);
        System.out.println(this.requestCount + "\n\n\n");
        t.setName("NanoHttpd Request Processor (#" + this.requestCount + ")");
        return t;
    }
}
