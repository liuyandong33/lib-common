package build.dream.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonUtils {
    private static final SerializerFeature[] DEFAULT_SERIALIZER_FEATURES = new SerializerFeature[]{
            SerializerFeature.WriteDateUseDateFormat,
            SerializerFeature.WriteMapNullValue,
            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.DisableCircularReferenceDetect
    };

    public static String toJSONString(Object object) {
        return toJSONString(object, DEFAULT_SERIALIZER_FEATURES);
    }

    public static String toJSONString(Object object, SerializerFeature... serializerFeatures) {
        return JSON.toJSONString(object, serializerFeatures);
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }
}
