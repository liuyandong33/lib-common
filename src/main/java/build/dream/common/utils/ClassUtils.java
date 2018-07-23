package build.dream.common.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassUtils {
    public static String encodeClassAsBase64(Class<?> clazz) throws IOException {
        InputStream inputStream = ClassUtils.class.getResourceAsStream(clazz.getName().replaceAll("\\.", "/") + ".class");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = 0;
        byte[] buffer = new byte[1024];
        while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
            byteArrayOutputStream.write(buffer, 0, length);
        }
        String base64String = Base64.encodeBase64String(byteArrayOutputStream.toByteArray());
        inputStream.close();
        byteArrayOutputStream.close();
        return base64String;
    }
}
