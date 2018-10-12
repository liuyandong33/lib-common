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
        String zippedText = null;
        if (StringUtils.isBlank(text)) {
            zippedText = text;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = null;
            ZipOutputStream zipOutputStream = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                zipOutputStream.putNextEntry(new ZipEntry("0"));
                zipOutputStream.write(text.getBytes());
                zipOutputStream.closeEntry();
                zippedText = Base64.encodeBase64String(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                IOUtils.close(zipOutputStream);
                IOUtils.close(byteArrayOutputStream);
            }
        }
        return zippedText;
    }

    public static final String unzipText(String zippedText) {
        String text = null;
        if (StringUtils.isBlank(zippedText)) {
            text = zippedText;
        } else {
            ByteArrayInputStream byteArrayInputStream = null;
            ZipInputStream zipInputStream = null;
            try {
                byte[] data = Base64.decodeBase64(zippedText);
                byteArrayInputStream = new ByteArrayInputStream(data);
                zipInputStream = new ZipInputStream(byteArrayInputStream);
                zipInputStream.getNextEntry();
                text = IOUtils.toString(zipInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                IOUtils.close(zipInputStream);
                IOUtils.close(byteArrayInputStream);
            }
        }
        return text;
    }
}
