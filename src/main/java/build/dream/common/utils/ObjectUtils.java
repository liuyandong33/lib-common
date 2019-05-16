package build.dream.common.utils;

public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    public static boolean isNull(Object object) {
        return object == null;
    }
}
