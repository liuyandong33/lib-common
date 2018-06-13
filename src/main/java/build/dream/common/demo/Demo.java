package build.dream.common.demo;

import build.dream.common.utils.GsonUtils;
import org.apache.commons.codec.binary.Hex;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\liuyandong\\Desktop\\Demo.class");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = fileInputStream.read(buffer, 0, 1024)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }

        byte[] byteArray = byteArrayOutputStream.toByteArray();

        String magic = Hex.encodeHexString(new byte[]{byteArray[0], byteArray[1], byteArray[2], byteArray[3]});
        System.out.println("magic: " + magic);

        int minorVersion = byteArray[5] & 0xFF | (byteArray[4] & 0xFF) << 8;
        System.out.println("minor_version: " + minorVersion);

        int majorVersion = byteArray[7] & 0xFF | (byteArray[6] & 0xFF) << 8;
        System.out.println("major_version: " + majorVersion);

        int constantPoolCount = byteArray[9] & 0xFF | (byteArray[8] & 0xFF) << 8;
        System.out.println("constant_pool_count: " + constantPoolCount);

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


        Map<Integer, Object> constantContentMap = new HashMap<Integer, Object>();

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

                constantContentMap.put(index, new String(array));
            } else if (tag == 3) {
                int value = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 1] & 0xFF) << 8;
                constantContentMap.put(index, value);
                offset = offset + 1 + 4;
            } else if (tag == 4) {
                int value = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 1] & 0xFF) << 8;
                constantContentMap.put(index, value);
                offset = offset + 1 + 4;
            } else if (tag == 5) {
                int value = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 1] & 0xFF) << 8;
                constantContentMap.put(index, value);
                offset = offset + 1 + 8;
            } else if (tag == 6) {
                int value = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 3] & 0xFF) << 8 | (byteArray[offset + 1] & 0xFF) << 8;
                offset = offset + 1 + 8;
                constantContentMap.put(index, value);
            } else if (tag == 7) {
                int value = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;
                System.out.println(value);
                constantContentMap.put(index, value);
                offset = offset + 1 + 2;
            } else if (tag == 8) {
                int value = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;
                System.out.println(value);
                constantContentMap.put(index, value);
                offset = offset + 1 + 2;
            } else if (tag == 9) {
                int value1 = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;

                int value2 = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8;

                constantContentMap.put(index, value1 + " " + value2);
                offset = offset + 1 + 4;
            } else if (tag == 10) {
                int value1 = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;

                int value2 = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8;

                constantContentMap.put(index, value1 + " " + value2);
                offset = offset + 1 + 4;
            } else if (tag == 11) {
                int value1 = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;

                int value2 = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8;

                constantContentMap.put(index, value1 + " " + value2);
                offset = offset + 1 + 4;
            } else if (tag == 12) {
                int value1 = byteArray[offset + 2] & 0xFF | (byteArray[offset + 1] & 0xFF) << 8;

                int value2 = byteArray[offset + 4] & 0xFF | (byteArray[offset + 3] & 0xFF) << 8;

                constantContentMap.put(index, value1 + " " + value2);
                offset = offset + 1 + 4;
            }
        }
        System.out.println(GsonUtils.toJson(constantContentMap));
    }
}
