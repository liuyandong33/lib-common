package build.dream.common.demo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AccessFlagUtils {
    private static Map<Integer, String> classAccessFlagsMap = new LinkedHashMap<Integer, String>();
    private static Map<Integer, String> fieldAccessFlagsMap = new LinkedHashMap<Integer, String>();

    static {
        classAccessFlagsMap.put(0x0001, "ACC_PUBLIC");
        classAccessFlagsMap.put(0x0010, "ACC_FINAL");
        classAccessFlagsMap.put(0x0020, "ACC_SUPER");
        classAccessFlagsMap.put(0x0200, "ACC_INTERFACE");
        classAccessFlagsMap.put(0x0400, "ACC_ABSTRACT");
        classAccessFlagsMap.put(0x1000, "ACC_SYNTHETIC");
        classAccessFlagsMap.put(0x2000, "ACC_ANNOTATION");
        classAccessFlagsMap.put(0x4000, "ACC_ENUM");

        fieldAccessFlagsMap.put(0x0001, "ACC_PUBLIC");
        fieldAccessFlagsMap.put(0x0002, "ACC_PRIVATE");
        fieldAccessFlagsMap.put(0x0004, "ACC_PROTECTED");
        fieldAccessFlagsMap.put(0x0008, "ACC_STATIC");
        fieldAccessFlagsMap.put(0x0010, "ACC_FINAL");
        fieldAccessFlagsMap.put(0x0040, "ACC_VOLATILE");
        fieldAccessFlagsMap.put(0x0080, "ACC_TRANSIENT");
        fieldAccessFlagsMap.put(0x1000, "ACC_SYNTHETIC");
        fieldAccessFlagsMap.put(0x4000, "ACC_ENUM");
    }

    public static List<String> obtainClassAccessFlags(int accessFlagsHex) {
        List<String> accessFlags = new ArrayList<String>();
        for (Map.Entry<Integer, String> entry : classAccessFlagsMap.entrySet()) {
            int key = entry.getKey();
            if ((accessFlagsHex & key) != 0) {
                accessFlags.add(entry.getValue());
            }
        }
        return accessFlags;
    }

    public static List<String> obtainFieldAccessFlags(int accessFlagsHex) {
        List<String> accessFlags = new ArrayList<String>();
        for (Map.Entry<Integer, String> entry : fieldAccessFlagsMap.entrySet()) {
            int key = entry.getKey();
            if ((accessFlagsHex & key) != 0) {
                accessFlags.add(entry.getValue());
            }
        }
        return accessFlags;
    }
}
