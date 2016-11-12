package walkingdevs.http11;

import walkingdevs.bytes.mBytes;
import walkingdevs.chset.Chset;
import walkingdevs.str.mStr;

class RespBodyImpl implements RespBody {
    public byte[] get() {
        return mBytes.mk(bytes).copy();
    }

    public int length() {
        return bytes.length;
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public String text() {
        return mStr.mk(bytes).get();
    }

    public String text(Chset chset) {
        return mStr.mk(bytes, chset).get();
    }

    RespBodyImpl(byte[] bytes) {
        this.bytes = bytes;
    }

    private final byte[] bytes;
}