import org.junit.Assert;
import org.junit.Test;
import walkingdevs.tcp.Tcp;

import java.io.IOException;
import java.io.InputStream;

public class TcpTest extends Assert {
    @Test
    public void shouldTransmitAndReceive() {
        StringBuilder sb = new StringBuilder();
        Tcp.server()
            .handler(socket -> {
                try (InputStream is = socket.getInputStream()) {
                    byte[] buffer = new byte[1024];
                    int read;
                    while ((read = is.read(buffer)) != -1) {
                        sb.append(
                            new String(buffer, 0, read)
                        );
                    }
                } catch (IOException exception) {
                    throw new RuntimeException(
                        exception
                    );
                }
            })
            .success(() -> {
                Tcp.client().build(client -> {
                    client.write("h")
                        .write("e")
                        .write("l")
                        .write("l")
                        .write("o")
                        .write(", world!");
                    // TODO: hack
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                assertEquals(
                    "hello, world!",
                    sb.toString()
                );
            })
            .await(true)
            .build()
            .start();
    }
}