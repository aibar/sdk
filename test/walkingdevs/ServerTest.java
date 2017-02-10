package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.http11.IP;
import walkingdevs.http11.Port;
import walkingdevs.http11.ServerBuilder;

public class ServerTest extends Assert {
    @Test
    public void test() {
        ServerBuilder.mk(IP.mk(), Port.mk(80))
            .build()
            .start()
            .await();
    }
}