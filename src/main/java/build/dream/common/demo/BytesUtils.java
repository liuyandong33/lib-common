package build.dream.common.demo;

import org.apache.commons.lang.ArrayUtils;

public class BytesUtils {
    public static int byteArrayToInt(byte[] bytes, int index, int length) {
        if (length == 1) {
            return bytes[index];
        } else if (length == 2) {
            return bytes[index + 1] & 0xFF | (bytes[index] & 0xFF) << 8;
        } else if (length == 3) {
            return bytes[index + 2] & 0xFF | (bytes[index + 1] & 0xFF) << 8 | (bytes[index] & 0xFF) << 16;
        } else if (length == 4) {
            return bytes[index + 3] & 0xFF | (bytes[index + 2] & 0xFF) << 8 | (bytes[index + 1] & 0xFF) << 16 | (bytes[0] & 0xFF) << 24;
        }
        return 0;
    }

    public static String byteArrayToString(byte[] bytes, int index, int length) {
        byte[] array = ArrayUtils.subarray(bytes, index, index + length);
        return new String(array);
    }
}
