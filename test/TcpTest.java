import org.junit.Assert;
import org.junit.Test;
import walkingdevs.exceptions.Try;
import walkingdevs.http11.Port;
import walkingdevs.str.Str;
import walkingdevs.stream.Is;
import walkingdevs.tcp.Tcp;

public class TcpTest extends Assert {
    @Test
    public void test() {
        StringBuilder sb = new StringBuilder();
        Tcp.server(Port.mk(4000), (socket) -> {
            Try.mk(() -> {
                sb.append(
                    Str.mk(
                        Is.mk(
                            socket.getInputStream()
                        ).bytes()
                    )
                );
                return Void.TYPE;
            });
        });
        Tcp.client(Port.mk(4000), (client) -> {
            client.req("1").send();
            client.req("2").send();
            client.req("3").send();
        });
        assertEquals(
            "123",
            sb.toString()
        );
    }
}