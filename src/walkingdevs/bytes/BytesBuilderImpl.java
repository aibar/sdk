package walkingdevs.bytes;

import java.util.ArrayList;
import java.util.List;

class BytesBuilderImpl implements BytesBuilder {
    public byte[] get() {
        byte[] all = new byte[length];
        int i = 0;
        for (byte[] bytes : bytesList) {
            for (byte b : bytes) {
                all[i++] = b;
            }
        }
        return all;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return bytesList.isEmpty();
    }

    public BytesBuilder add(byte[] bytes) {
        if (!Bytes.mk(bytes).isEmpty()) {
            bytesList.add(bytes);
            length += bytes.length;
        }
        return this;
    }

    BytesBuilderImpl() {
        this.bytesList = new ArrayList<>();
    }

    private final List<byte[]> bytesList;
    private int length = 0;
}