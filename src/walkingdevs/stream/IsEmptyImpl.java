package walkingdevs.stream;

import java.io.IOException;
import java.io.OutputStream;

class IsEmptyImpl implements Is {
    public byte[] bytes() {
        return new byte[0];
    }

    public boolean isEmpty() {
        return true;
    }

    public void writeTo(OutputStream os) throws IOException {
        // Do nothing
    }
}