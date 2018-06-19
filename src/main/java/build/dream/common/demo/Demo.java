package build.dream.common.demo;

import build.dream.common.utils.GsonUtils;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

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

        List<String> accessFlags = AccessFlagUtils.obtainClassAccessFlags(BytesUtils.byteArrayToInt(byteArray, offset, 2));
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
            field.put("access_flags", StringUtils.join(AccessFlagUtils.obtainFieldAccessFlags(BytesUtils.byteArrayToInt(byteArray, offset, 2)), " "));
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
            methodInfo.put("access_flags", StringUtils.join(AccessFlagUtils.obtainMethodAccessFlags(BytesUtils.byteArrayToInt(byteArray, offset, 2)), " "));
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
//                        codes.add(BytesUtils.byteArrayToHex(byteArray, offset, 1));
                        codes.add(BytesUtils.byteArrayToAsciiString(byteArray, offset, 1));
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

                    int attributes_count = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                    offset = offset + 2;
                    codeInfo.put("attributes_count", attributes_count);

                    List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
                    for (int k = 0; k < attributes_count; k++) {
                        Map<String, Object> map = new LinkedHashMap<String, Object>();

                        int attribute_name_index = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                        offset = offset + 2;
                        map.put("attribute_name_index", attribute_name_index);

                        int attribute_length = BytesUtils.byteArrayToInt(byteArray, offset, 4);
                        offset = offset + 4;
                        map.put("attribute_length", attribute_length);

                        String attribute_name = ConstantPoolUtils.obtainAttributeName(constantContentMap, constantIndexAndTagMap, attribute_name_index);
                        if ("LineNumberTable".equals(attribute_name)) {
                            int line_number_table_length = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                            offset = offset + 2;

                            List<Map<Integer, Integer>> lineNumberTable = new ArrayList<Map<Integer, Integer>>();
                            for (int j = 0; j < line_number_table_length; j++) {
                                Map<Integer, Integer> lineNumber = new LinkedHashMap<Integer, Integer>();
                                int key = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                                offset = offset + 2;

                                int value = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                                offset = offset + 2;

                                lineNumber.put(key, value);

                                lineNumberTable.add(lineNumber);
                            }

                            map.put("info", lineNumberTable);
                        } else if ("StackMapTable".equals(attribute_name)) {
                            int number_of_entries = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                            offset = offset + 2;

                            List<Map<String, Object>> stackMapFrameInfos = new ArrayList<Map<String, Object>>();
                            for (int j = 0; j < number_of_entries; j++) {
                                Map<String, Object> stackMapFrameInfo = new LinkedHashMap<String, Object>();

                                int tag = BytesUtils.byteArrayToInt(byteArray, offset, 1);
                                offset = offset + 1;
                                stackMapFrameInfo.put("frame_type", tag);

                                if (tag >= 0 && tag <= 63) {

                                } else if (tag >= 64 && tag <= 127) {
                                    int ta = BytesUtils.byteArrayToInt(byteArray, offset, 1);
                                    offset = offset + 1;

                                    if (ta == 0) {

                                    } else if (ta == 1) {

                                    } else if (ta == 2) {

                                    } else if (ta == 3) {

                                    } else if (ta == 4) {

                                    } else if (ta == 5) {

                                    } else if (ta == 6) {

                                    } else if (ta == 7) {
                                        int cpool_index = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                                        stackMapFrameInfo.put("stack", cpool_index);
                                        offset = offset + 2;
                                    } else if (ta == 8) {

                                    }
                                } else if (tag >= 128 && tag <= 246) {

                                } else if (tag == 247) {

                                } else if (tag >= 248 && tag <= 250) {

                                } else if (tag == 251) {

                                } else if (tag >= 252 && tag <= 254) {

                                } else if (tag == 255) {

                                }

                                stackMapFrameInfos.add(stackMapFrameInfo);
                            }
                            map.put("info", stackMapFrameInfos);
                        }
                        maps.add(map);
                    }

                    codeInfo.put("attributes", maps);
//                    offset = offset + attributeLength - 10 - codeLength - exceptionTableLength * 8 - 2 - 2;

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

        int attributesCount = BytesUtils.byteArrayToInt(byteArray, offset, 2);
        offset = offset + 2;

        List<Map<String, Object>> attributes = new ArrayList<Map<String, Object>>();
        for (int index = 0; index < attributesCount; index++) {
            Map<String, Object> attribute = new LinkedHashMap<String, Object>();

            int attribute_name_index = BytesUtils.byteArrayToInt(byteArray, offset, 2);
            offset = offset + 2;
            attribute.put("attribute_name_index", attribute_name_index);

            int attribute_length = BytesUtils.byteArrayToInt(byteArray, offset, 4);
            offset = offset + 4;
            attribute.put("attribute_length", attribute_length);

            String attributeName = ConstantPoolUtils.obtainAttributeName(constantContentMap, constantIndexAndTagMap, attribute_name_index);
            if ("SourceFile".equals(attributeName)) {
                int sourcefile_index = BytesUtils.byteArrayToInt(byteArray, offset, 2);
                attribute.put("sourcefile_index", sourcefile_index);
                offset = offset + 2;
            }
            attributes.add(attribute);
        }

        Map<String, Object> classInfo = new LinkedHashMap<String, Object>();
        classInfo.put("magic", magic);
        classInfo.put("minor_version", minorVersion);
        classInfo.put("major_version", majorVersion);
        classInfo.put("constant_pool_count", constantPoolCount);
        classInfo.put("constant_pool", constantContentMap);
        classInfo.put("access_flags", StringUtils.join(accessFlags, " "));
        classInfo.put("this_class", thisClass);
        classInfo.put("super_class", superClass);
        classInfo.put("interfaces_count", interfacesCount);
        classInfo.put("interfaces", interfaces);
        classInfo.put("fields_count", fieldsCount);
        classInfo.put("fields", fields);
        classInfo.put("methods_count", methodsCount);
        classInfo.put("methods", methods);
        classInfo.put("attributes_count", attributesCount);
        classInfo.put("attributes", attributes);

        System.out.println(GsonUtils.toJson(classInfo));
    }
}
