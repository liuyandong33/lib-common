package build.dream.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    public static String zipText(String text) {
        String compressedText = null;
        if (StringUtils.isBlank(text)) {
            compressedText = text;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = null;
            ZipOutputStream zipOutputStream = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                zipOutputStream.putNextEntry(new ZipEntry("0"));
                zipOutputStream.write(text.getBytes());
                zipOutputStream.closeEntry();
                compressedText = Base64.encodeBase64String(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                closeZipOutputStream(zipOutputStream);
                closeByteArrayOutputStream(byteArrayOutputStream);
            }
        }
        return compressedText;
    }

    private static void closeZipInputStream(ZipInputStream zipInputStream) {
        if (zipInputStream != null) {
            try {
                zipInputStream.close();
            } catch (IOException e) {
                zipInputStream = null;
            }
        }
    }

    private static void closeZipOutputStream(ZipOutputStream zipOutputStream) {
        if (zipOutputStream != null) {
            try {
                zipOutputStream.close();
            } catch (IOException e) {
                zipOutputStream = null;
            }
        }
    }

    private static void closeByteArrayInputStream(ByteArrayInputStream byteArrayInputStream) {
        if (byteArrayInputStream != null) {
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                byteArrayInputStream = null;
            }
        }
    }

    private static void closeByteArrayOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                byteArrayOutputStream = null;
            }
        }
    }

    public static final String unzipText(String compressedText) {
        String text = null;
        if (StringUtils.isBlank(compressedText)) {
            text = compressedText;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = null;
            ByteArrayInputStream byteArrayInputStream = null;
            ZipInputStream zipInputStream = null;
            try {
                byte[] compressed = Base64.decodeBase64(compressedText);
                byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayInputStream = new ByteArrayInputStream(compressed);
                zipInputStream = new ZipInputStream(byteArrayInputStream);
                zipInputStream.getNextEntry();
                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, length);
                }
                text = byteArrayOutputStream.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                closeZipInputStream(zipInputStream);
                closeByteArrayInputStream(byteArrayInputStream);
                closeByteArrayOutputStream(byteArrayOutputStream);
            }
        }
        return text;
    }
}
