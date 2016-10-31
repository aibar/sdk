package walkingdevs.http11;

import walkingdevs.bytes.MBytes;
import walkingdevs.chset.Chset;
import walkingdevs.str.MStr;

class RespBodyImpl implements RespBody {
    public byte[] get() {
        return MBytes.mk(bytes).get();
    }

    public int length() {
        return bytes.length;
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public String text() {
        return MStr.mk(bytes).get();
    }

    public String text(Chset chset) {
        return MStr.mk(bytes, chset).get();
    }

    RespBodyImpl(byte[] bytes) {
        this.bytes = bytes;
    }

    private final byte[] bytes;
}