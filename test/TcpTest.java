import org.junit.Assert;
import org.junit.Test;
import walkingdevs.exceptions.Try;
import walkingdevs.str.Str;
import walkingdevs.stream.Is;
import walkingdevs.tcp.Tcp;

public class TcpTest extends Assert {
    @Test
    public void shouldTransmitAndReceive() {
        StringBuilder sb = new StringBuilder();
        Tcp.server()
            .handler(socket -> {
                Try.mk(() -> {
                    sb.append(
                        Str.mk(
                            Is.mk(socket.getInputStream()).bytes()
                        )
                    );
                    return Void.TYPE;
                });
            })
            .success(() -> {
                Tcp.client().build(client -> {
                    client.write("h")
                        .write("e")
                        .write("l")
                        .write("l")
                        .write("o")
                        .write(", world!");
                    assertEquals(
                        "hello, world!",
                        sb.toString()
                    );
                });
            })
            .await(false)
            .build()
            .start();
    }
}