package walkingdevs.stream;

import walkingdevs.iter.Itor;
import walkingdevs.iter.$Itor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

class BufferedIsEmptyImpl implements BufferedIs {
    public boolean isEmpty() {
        return true;
    }

    public void writeTo(OutputStream os) throws IOException {
        // Do nothing
    }

    @Override
    public Iterator<byte[]> iterator() {
        return itor.get();
    }

    private final Itor<byte[]> itor = $Itor.mk();
}