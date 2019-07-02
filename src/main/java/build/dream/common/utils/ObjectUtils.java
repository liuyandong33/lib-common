package build.dream.common.utils;

import org.apache.commons.lang3.SerializationUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Objects;

public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {
    public static boolean isNotNull(Object object) {
        return Objects.nonNull(object);
    }

    public static boolean isNull(Object object) {
        return Objects.isNull(object);
    }

    public static byte[] serialize(Serializable object) {
        return SerializationUtils.serialize(object);
    }

    public static void serialize(Serializable object, OutputStream outputStream) {
        SerializationUtils.serialize(object, outputStream);
    }

    public static <T> T deserialize(byte[] objectData) {
        return SerializationUtils.deserialize(objectData);
    }

    public static <T> T deserialize(InputStream inputStream) {
        return SerializationUtils.deserialize(inputStream);
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
