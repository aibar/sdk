package walkingdevs.stream;

import walkingdevs.bytes.Bytes;
import walkingdevs.Problems;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

class IsImpl implements Is {
    public Bytes bytes() {
        return bytes;
    }

    @Override
    public Iterator<Byte> iterator() {
        return bytes().iterator();
    }

    @Override
    public void close() throws Exception {
        is.close();
    }

    IsImpl(InputStream is) {
        this.is = is;

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        try {
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException fail) {
            throw Problems.weFucked(fail);
        }
        bytes = Bytes.mk(os.toByteArray());
    }

    private final Bytes bytes;
    private final InputStream is;
}