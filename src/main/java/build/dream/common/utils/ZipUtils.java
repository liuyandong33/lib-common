package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
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
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                 ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            ) {
                zipOutputStream.putNextEntry(new ZipEntry("0"));
                zipOutputStream.write(text.getBytes());
                zipOutputStream.closeEntry();
                zippedText = Base64.encodeBase64String(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return zippedText;
    }

    public static final String unzipText(String zippedText) {
        String text = null;
        if (StringUtils.isBlank(zippedText)) {
            text = zippedText;
        } else {
            byte[] data = Base64.decodeBase64(zippedText);
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
                 ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream)) {
                zipInputStream.getNextEntry();
                text = IOUtils.toString(zipInputStream, Constants.CHARSET_UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return text;
    }
}
