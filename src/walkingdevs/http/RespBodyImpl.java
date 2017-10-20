package walkingdevs.http;

import walkingdevs.bytes.Bytes;
import walkingdevs.chset.Chset;
import walkingdevs.str.Str;

class RespBodyImpl implements RespBody {
    public byte[] get() {
        return Bytes.mk(bytes).copy();
    }

    public int length() {
        return bytes.length;
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public String text() {
        return Str.mk(bytes).get();
    }

    public String text(Chset chset) {
        return Str.mk(bytes, chset).get();
    }

    RespBodyImpl(byte[] bytes) {
        this.bytes = bytes;
    }

    private final byte[] bytes;
}