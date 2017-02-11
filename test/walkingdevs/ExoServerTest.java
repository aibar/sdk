package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.http11.IP;
import walkingdevs.http11.Port;
import walkingdevs.http11.exo.Exo;

public class ExoServerTest extends Assert {
    @Test
    public void test() {
        Exo.mk(IP.mk(), Port.mk(80))
            .build()
            .start();
    }
}