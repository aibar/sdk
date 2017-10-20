import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.Bytes;
import walkingdevs.http.Host;

public class HostTest extends Assert {
    @Test
    public void shouldParseFromIPString() {
        assertEquals(
            Bytes.mk(
                new byte[] {-64, -88, 1, 1}
            ),
            Bytes.mk(
                Host.mk("192.168.1.1").inet().getAddress()
            )
        );
    }

    @Test
    public void shouldMkLocal() {
        assertEquals(
            Bytes.mk(
                new byte[] {127, 0, 0, 1}
            ),
            Bytes.mk(
                Host.local().inet().getAddress()
            )
        );
    }

    @Test
    public void shouldMkAll() {
        assertEquals(
            Bytes.mk(
                new byte[] {0, 0, 0, 0}
            ),
            Bytes.mk(
                Host.all().inet().getAddress()
            )
        );
    }
}