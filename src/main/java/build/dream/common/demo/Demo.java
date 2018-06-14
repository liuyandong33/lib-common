package build.dream.common.demo;

import build.dream.common.utils.GsonUtils;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.util.ByteUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\liuyandong\\Desktop\\Test.class");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = fileInputStream.read(buffer, 0, 1024)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }

        byte[] byteArray = byteArrayOutputStream.toByteArray();

        String magic = Hex.encodeHexString(new byte[]{byteArray[0], byteArray[1], byteArray[2], byteArray[3]});

        int minorVersion = BytesUtils.byteArrayToInt(byteArray, 4, 2);

        int majorVersion = BytesUtils.byteArrayToInt(byteArray, 6, 2);

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
        Map<Integer, Integer> constantIndexAndTagMap = new LinkedHashMap<Integer, Integer>();

        int offset = 10;
        for (int index = 1; index < constantPoolCount; index++) {
            int tag = byteArray[offset];
            offset = offset + 1;

            if (tag == 1) {
                int length = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), BytesUtils.byteArrayToString(byteArray, offset, length));
                offset = offset + length;
            } else if (tag == 3) {
                int value = BytesUtils.byteArrayToInt(byteArray, offset, 4);
                offset = offset + 4;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
            } else if (tag == 4) {
                int value = BytesUtils.byteArrayToInt(byteArray, offset, 4);
                offset = offset + 4;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
            } else if (tag == 5) {
                int value = BytesUtils.byteArrayToInt(byteArray, offset, 4);
                offset = offset + 4;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
            } else if (tag == 6) {
                int value = BytesUtils.byteArrayToInt(byteArray, offset, 4);
                offset = offset + 4;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
            } else if (tag == 7) {
                int value = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
            } else if (tag == 8) {
                int value = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value);
            } else if (tag == 9) {
                int value1 = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                int value2 = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value1 + " " + value2);
            } else if (tag == 10) {
                int value1 = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                int value2 = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value1 + " " + value2);
            } else if (tag == 11) {
                int value1 = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                int value2 = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value1 + " " + value2);
            } else if (tag == 12) {
                int value1 = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                int value2 = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;

                constantContentMap.put(index + "_" + constantTypeMap.get(tag), value1 + " " + value2);
            }
            constantIndexAndTagMap.put(index, tag);
        }

        String accessFlags = BytesUtils.byteArrayToHex(byteArray, offset, 2);
        offset = offset + 2;

        int thisClass = BytesUtils.byteArrayToInt(byteArray, offset, 2);
        offset = offset + 2;

        int superClass = BytesUtils.byteArrayToInt(byteArray, offset, 2);
        offset = offset + 2;

        int interfacesCount = BytesUtils.byteArrayToInt(byteArray, offset, 2);
        offset = offset + 2;

        List<Integer> interfaces = new ArrayList<Integer>();
        for (int index = 0; index < interfacesCount; index++) {
            interfaces.add(BytesUtils.byteArrayToInt(byteArray, offset, 2));
            offset = offset + 2;
        }

        int fieldsCount = BytesUtils.byteArrayToInt(byteArray, offset, 2);
        offset = offset + 2;

        List<Map<String, Object>> fields = new ArrayList<Map<String, Object>>();
        for (int index = 0; index < fieldsCount; index++) {
            Map<String, Object> field = new LinkedHashMap<String, Object>();
            field.put("access_flags", BytesUtils.byteArrayToHex(byteArray, offset, 2));
            offset = offset + 2;

            field.put("name_index", BytesUtils.byteArrayToInt(byteArray, offset, 2));
            offset = offset + 2;

            field.put("descriptor_index", BytesUtils.byteArrayToInt(byteArray, offset, 2));
            offset = offset + 2;

            int attributesCount = BytesUtils.byteArrayToInt(byteArray, offset, 2);
            offset = offset + 2;
            field.put("attributes_count", attributesCount);

            List<Map<String, Object>> attributes = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < attributesCount; i++) {
                Map<String, Object> attributeInfo = new LinkedHashMap<String, Object>();

                int attributeNameIndex = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                offset = offset + 2;
                attributeInfo.put("attribute_name_index", attributeNameIndex);

                int attributeLength = BytesUtils.byteArrayToInt(byteArray, offset, 4);
                attributeInfo.put("attribute_length", attributeLength);
                offset = offset + 4;

                String attributeName = ConstantPoolUtils.obtainAttributeName(constantContentMap, constantIndexAndTagMap, attributeNameIndex);
                Object info = null;
                if ("ConstantValue".equals(attributeName)) {
                    info = attributeName + "_" + BytesUtils.byteArrayToInt(byteArray, offset, attributeLength);
                } else if ("Deprecated".equals(attributeName)) {

                } else if ("Synthetic".equals(attributeName)) {

                }
                offset = offset + attributeLength;
                attributeInfo.put("info", info);

                attributes.add(attributeInfo);
            }
            if (attributesCount > 0) {
                field.put("attributes", attributes);
            }

            fields.add(field);
        }

        int methodsCount = BytesUtils.byteArrayToInt(byteArray, offset, 2);
        offset = offset + 2;

        List<Map<String, Object>> methods = new ArrayList<Map<String, Object>>();
        for (int index = 0; index < methodsCount; index++) {
            Map<String, Object> methodInfo = new LinkedHashMap<String, Object>();
            methodInfo.put("access_flags", BytesUtils.byteArrayToHex(byteArray, offset, 2));
            offset = offset + 2;

            methodInfo.put("name_index", BytesUtils.byteArrayToInt(byteArray, offset, 2));
            offset = offset + 2;

            methodInfo.put("descriptor_index", BytesUtils.byteArrayToInt(byteArray, offset, 2));
            offset = offset + 2;

            int attributesCount = BytesUtils.byteArrayToInt(byteArray, offset, 2);
            methodInfo.put("attributes_count", attributesCount);
            offset = offset + 2;

            List<Map<String, Object>> attributes = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < attributesCount; i++) {
                Map<String, Object> attributeInfo = new LinkedHashMap<String, Object>();
                int attributeNameIndex = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                attributeInfo.put("attribute_name_index", attributeNameIndex);
                offset = offset + 2;

                int attributeLength = BytesUtils.byteArrayToInt(byteArray, offset, 4);
                attributeInfo.put("attribute_length", attributeLength);
                offset = offset + 4;

                String attributeName = ConstantPoolUtils.obtainAttributeName(constantContentMap, constantIndexAndTagMap, attributeNameIndex);
                Object info = null;
                if ("Code".equals(attributeName)) {
                    Map<String, Object> codeInfo = new LinkedHashMap<String, Object>();
                    int maxStack = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                    codeInfo.put("max_stack", maxStack);
                    offset = offset + 2;

                    int maxLocals = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                    codeInfo.put("max_locals", maxLocals);
                    offset = offset + 2;

                    int codeLength = BytesUtils.byteArrayToInt(byteArray, offset, 4);
                    codeInfo.put("code_length", codeLength);
                    offset = offset + 4;

                    List<String> codes = new ArrayList<String>();
                    for (int j = 0; j < codeLength; j++) {
                        codes.add(BytesUtils.byteArrayToHex(byteArray, offset, 1));
                        offset = offset + 1;
                    }
                    codeInfo.put("codes", StringUtils.join(codes, ", "));

                    int exceptionTableLength = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                    codeInfo.put("exception_table_length", exceptionTableLength);
                    offset = offset + 2;

                    Map<String, Object> exceptionInfo = new LinkedHashMap<String, Object>();
                    for (int j = 0; j < exceptionTableLength; j++) {
                        exceptionInfo.put("start_pc", BytesUtils.byteArrayToInt(byteArray, offset, 2));
                        offset = offset + 2;

                        exceptionInfo.put("end_pc", BytesUtils.byteArrayToInt(byteArray, offset, 2));
                        offset = offset + 2;

                        exceptionInfo.put("handler_pc", BytesUtils.byteArrayToInt(byteArray, offset, 2));
                        offset = offset + 2;

                        exceptionInfo.put("catch_type", BytesUtils.byteArrayToInt(byteArray, offset, 2));
                        offset = offset + 2;
                    }
                    if (exceptionTableLength > 0) {
                        codeInfo.put("exception_info", exceptionInfo);
                    }

                    offset = offset + attributeLength - 10 - codeLength - exceptionTableLength * 8;

                    info = codeInfo;
                }
                attributeInfo.put("info", info);

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
