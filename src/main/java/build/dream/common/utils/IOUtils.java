package build.dream.common.utils;

import build.dream.common.constants.Constants;

import javax.servlet.ServletOutputStream;
import java.io.*;

public class IOUtils {
    public static String toString(InputStream inputStream) {
        return toString(inputStream, Constants.CHARSET_NAME_UTF_8, false);
    }

    public static String toString(InputStream inputStream, String charsetName) {
        return toString(inputStream, charsetName, false);
    }

    public static String toString(InputStream inputStream, boolean closed) {
        return toString(inputStream, Constants.CHARSET_NAME_UTF_8, closed);
    }

    public static String toString(InputStream inputStream, String charsetName, boolean closed) {
        try {
            StringBuffer result = new StringBuffer();
            Reader reader = new InputStreamReader(inputStream, charsetName);
            int length = 0;
            char[] buffer = new char[1024];
            while ((length = reader.read(buffer, 0, 1024)) != -1) {
                result.append(buffer, 0, length);
            }
            reader.close();
            if (closed) {
                inputStream.close();
            }
            return result.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, boolean closed) throws IOException {
        int length = 0;
        byte[] buffer = new byte[1024];
        while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        if (closed) {
            inputStream.close();
            outputStream.close();
        }
    }

    public static void copy(InputStream inputStream, ServletOutputStream outputStream) throws IOException {
        copy(inputStream, outputStream, false);
    }
}
