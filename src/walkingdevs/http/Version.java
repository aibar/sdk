package walkingdevs.http;

import java.io.InputStream;

public enum Version {
    v10,
    v11,
    v20;

    public static Version parseFromRequest(InputStream is) {
        return null;
    }
}