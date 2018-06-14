package build.dream.common.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ConstantPoolUtils {
    private static final Map<Integer, String> CONSTANT_TYPE_MAP = new HashMap<Integer, String>();

    static {
        CONSTANT_TYPE_MAP.put(1, "Utf8");
        CONSTANT_TYPE_MAP.put(3, "Integer");
        CONSTANT_TYPE_MAP.put(4, "Float");
        CONSTANT_TYPE_MAP.put(5, "Long");
        CONSTANT_TYPE_MAP.put(6, "Double");
        CONSTANT_TYPE_MAP.put(7, "Class");
        CONSTANT_TYPE_MAP.put(8, "String");
        CONSTANT_TYPE_MAP.put(9, "Fieldref");
        CONSTANT_TYPE_MAP.put(10, "Methodref");
        CONSTANT_TYPE_MAP.put(11, "InterfaceMethodref");
        CONSTANT_TYPE_MAP.put(12, "NameAndType");
    }

    public static String obtainAttributeName(Map<String, Object> constantPool, Map<Integer, Integer> constantIndexAndTagMap, int index) {
        int tag = constantIndexAndTagMap.get(index);
        if (tag == 1) {
            return constantPool.get(index + "_" + CONSTANT_TYPE_MAP.get(tag)).toString();
        }
        return UUID.randomUUID().toString();
    }
}
