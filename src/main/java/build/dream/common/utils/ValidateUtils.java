package build.dream.common.utils;

import org.apache.commons.lang.Validate;

import java.util.Map;

public class ValidateUtils {
    public static void notNull(Map<String, String> map, String... keys) {
        for (String key : keys) {
            Validate.notNull(map.get(key), "参数(" + key + ")不能为空！");
        }
    }
}
