package build.dream.common.demo;

import build.dream.common.utils.GsonUtils;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/liuyandong/Desktop/Test.class");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = fileInputStream.read(buffer, 0, 1024)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }

        byte[] byteArray = byteArrayOutputStream.toByteArray();

        String magic = Hex.encodeHexString(new byte[]{byteArray[0], byteArray[1], byteArray[2], byteArray[3]});

        int minorVersion = byteArray[5] & 0xFF | (byteArray[4] & 0xFF) << 8;

        int majorVersion = byteArray[7] & 0xFF | (byteArray[6] & 0xFF) << 8;

        int constantPoolCount = byteArray[9] & 0xFF | (byteArray[8] & 0xFF) << 8;

        Map<Integer, String> constantTypeMap = new HashMap<Integer, String>();
        constantTypeMap.put(1, "Utf8");
        constantTypeMap.put(3, "Integer");
        constantTypeMap.put(4, "Float");
        constantTypeMap.put(5, "Long");
        constantTypeMap.put(6, "Double");
        constantTypeMap.put(7, "Class");
        constantTypeMap.put(8, "String");
        constantTypeMap.put(9, "Fieldref");
        constantTypeMap.put(10, "Methodref");
        constantTypeMap.put(11, "InterfaceMethodref");
        constantTypeMap.put(12, "NameAndType");


        Map<String, Object> constantContentMap = new LinkedHashMap<String, Object>();

        int offset = 10;
        for (int index = 1; index < constantPoolCount; index++) {
            int tag = byteArray[offset];
            if (tag == 1) {
                int length = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;
                byte array[] = new byte[length];
                for (int i = 0; i < length; i++) {
                    array[i] = byteArray[offset + 1 + 2 + i];
                }
                offset = offset + 1 + 2 + length;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), new String(array));
            } else if (tag == 3) {
                int value = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 3] & 0xFF) << 16 | (byteArray[offset + 1] & 0xFF) << 24;
                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
                offset = offset + 1 + 4;
            } else if (tag == 4) {
                int value = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 3] & 0xFF) << 16 | (byteArray[offset + 1] & 0xFF) << 24;
                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
                offset = offset + 1 + 4;
            } else if (tag == 5) {
                int value = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 3] & 0xFF) << 16 | (byteArray[offset + 1] & 0xFF) << 24;
                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
                offset = offset + 1 + 8;
            } else if (tag == 6) {
                int value = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 3] & 0xFF) << 16 | (byteArray[offset + 1] & 0xFF) << 24;
                offset = offset + 1 + 8;
                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
            } else if (tag == 7) {
                int value = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;
                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
                offset = offset + 1 + 2;
            } else if (tag == 8) {
                int value = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;
                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
                offset = offset + 1 + 2;
            } else if (tag == 9) {
                int value1 = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;

                int value2 = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value1 + " " + value2);
                offset = offset + 1 + 4;
            } else if (tag == 10) {
                int value1 = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;

                int value2 = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value1 + " " + value2);
                offset = offset + 1 + 4;
            } else if (tag == 11) {
                int value1 = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;

                int value2 = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value1 + " " + value2);
                offset = offset + 1 + 4;
            } else if (tag == 12) {
                int value1 = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;

                int value2 = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value1 + " " + value2);
                offset = offset + 1 + 4;
            }
        }

        String accessFlags = Hex.encodeHexString(new byte[]{byteArray[offset], byteArray[offset + 1]});
        offset = offset + 2;

        int thisClass = byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8;
        offset = offset + 2;

        int superClass = byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8;
        offset = offset + 2;

        int interfacesCount = byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8;
        offset = offset + 2;

        List<Integer> interfaces = new ArrayList<Integer>();
        for (int index = 0; index < interfacesCount; index++) {
            interfaces.add(byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8);
            offset = offset + 2;
        }

        int fieldsCount = byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8;
        offset = offset + 2;

        List<Map<String, Object>> fields = new ArrayList<Map<String, Object>>();
        for (int index = 0; index < fieldsCount; index++) {
            Map<String, Object> field = new LinkedHashMap<String, Object>();
            field.put("access_flags", Hex.encodeHexString(new byte[]{byteArray[offset], byteArray[offset + 1]}));
            offset = offset + 2;

            field.put("name_index", byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8);
            offset = offset + 2;

            field.put("descriptor_index", byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8);
            offset = offset + 2;

            int attributesCount = byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8;
            field.put("attributes_count", attributesCount);
            offset = offset + 2;

            List<Map<String, Object>> attributes = new ArrayList<Map<String, Object>>();
            for (int j = 0; j < attributesCount; j++) {
                Map<String, Object> attributeInfo = new LinkedHashMap<String, Object>();
                attributeInfo.put("attribute_name_index", byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8);
                offset = offset + 2;

                int attributeLength = byteArray[offset + 3] & 0xFF | (byteArray[offset + 2] & 0xFF) << 8 | (byteArray[offset + 1] & 0xFF) << 16 | (byteArray[offset + 0] & 0xFF) << 24;
                attributeInfo.put("attribute_length", attributeLength);
                offset = offset + 4;

                offset = offset + attributeLength;

                attributes.add(attributeInfo);
            }
            if (attributesCount > 0) {
                field.put("attributes", attributes);
            }

            fields.add(field);
        }

        int methodsCount = byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8;
        offset = offset + 2;

        List<Map<String, Object>> methods = new ArrayList<Map<String, Object>>();
        for (int index = 0; index < methodsCount; index++) {
            Map<String, Object> methodInfo = new LinkedHashMap<String, Object>();
            methodInfo.put("access_flags", Hex.encodeHexString(new byte[]{byteArray[offset], byteArray[offset + 1]}));
            offset = offset + 2;

            methodInfo.put("name_index", byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8);
            offset = offset + 2;

            methodInfo.put("descriptor_index", byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8);
            offset = offset + 2;

            int attributesCount = byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8;
            methodInfo.put("attributes_count", attributesCount);
            offset = offset + 2;

            List<Map<String, Object>> attributes = new ArrayList<Map<String, Object>>();
            for (int j = 0; j < attributesCount; j++) {
                Map<String, Object> attributeInfo = new LinkedHashMap<String, Object>();
                attributeInfo.put("attribute_name_index", byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8);
                offset = offset + 2;

                int attributeLength = byteArray[offset + 3] & 0xFF | (byteArray[offset + 2] & 0xFF) << 8 | (byteArray[offset + 1] & 0xFF) << 16 | (byteArray[offset + 0] & 0xFF) << 24;
                attributeInfo.put("attribute_length", attributeLength);
                offset = offset + 4;

                offset = offset + attributeLength;

                attributes.add(attributeInfo);
            }
            if (attributesCount > 0) {
                methodInfo.put("attributes", attributes);
            }

            methods.add(methodInfo);
        }

        int attributesCount = byteArray[offset + 1] & 0xFF | (byteArray[offset] & 0xFF) << 8;
        offset = offset + 2;

        Map<String, Object> classInfo = new LinkedHashMap<String, Object>();
        classInfo.put("magic", magic);
        classInfo.put("minor_version", minorVersion);
        classInfo.put("major_version", majorVersion);
        classInfo.put("constant_pool_count", constantPoolCount);
        classInfo.put("constant_pool", constantContentMap);
        classInfo.put("access_flags", accessFlags);
        classInfo.put("this_class", thisClass);
        classInfo.put("super_class", superClass);
        classInfo.put("interfaces_count", interfacesCount);
        classInfo.put("interfaces", interfaces);
        classInfo.put("fields_count", fieldsCount);
        classInfo.put("fields", fields);
        classInfo.put("methods_count", methodsCount);
        classInfo.put("methods", methods);

        System.out.println(GsonUtils.toJson(classInfo));
    }
}
