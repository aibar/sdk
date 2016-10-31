package walkingdevs.bytes;

import java.util.ArrayList;
import java.util.List;

class BytesBuilderImpl implements BytesBuilder {
    public byte[] get() {
        byte[] result = new byte[length];
        int i = 0;
        for (byte[] bytes : bytesList) {
            for (byte b : bytes) {
                result[i++] = b;
            }
        }
        return result;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return bytesList.isEmpty();
    }

    public BytesBuilder add(byte[] bytes) {
        if (!MBytes.mk(bytes).isEmpty()) {
            bytesList.add(bytes);
            length += bytes.length;
        }
        return this;
    }

    private final List<byte[]> bytesList = new ArrayList<byte[]>();
    private int length = 0;
}