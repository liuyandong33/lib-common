package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

import java.io.*;

public class TarUtils {
    public static String zipText(String text) {
        String zippedText = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        GzipCompressorOutputStream gzipCompressorOutputStream = null;
        TarArchiveOutputStream tarArchiveOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            gzipCompressorOutputStream = new GzipCompressorOutputStream(byteArrayOutputStream);
            tarArchiveOutputStream = new TarArchiveOutputStream(gzipCompressorOutputStream);

            byte[] data = text.getBytes(Constants.CHARSET_NAME_UTF_8);
            TarArchiveEntry tarArchiveEntry = new TarArchiveEntry("0");
            tarArchiveEntry.setSize(data.length);
            tarArchiveOutputStream.putArchiveEntry(tarArchiveEntry);
            tarArchiveOutputStream.write(text.getBytes(Constants.CHARSET_NAME_UTF_8));
            tarArchiveOutputStream.closeArchiveEntry();
            gzipCompressorOutputStream.finish();
            zippedText = Base64.encodeBase64String(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.close(tarArchiveOutputStream);
            IOUtils.close(byteArrayOutputStream);
            IOUtils.close(gzipCompressorOutputStream);
        }
        return zippedText;
    }

    public static String unzipText(String zippedText) {
        String text = null;
        ByteArrayInputStream byteArrayInputStream = null;
        GzipCompressorInputStream gzipCompressorInputStream = null;
        TarArchiveInputStream tarArchiveInputStream = null;
        try {
            byte[] data = Base64.decodeBase64(zippedText);
            byteArrayInputStream = new ByteArrayInputStream(data);
            gzipCompressorInputStream = new GzipCompressorInputStream(byteArrayInputStream);
            tarArchiveInputStream = new TarArchiveInputStream(gzipCompressorInputStream);
            tarArchiveInputStream.getNextTarEntry();
            text = IOUtils.toString(tarArchiveInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.close(byteArrayInputStream);
            IOUtils.close(gzipCompressorInputStream);
            IOUtils.close(tarArchiveInputStream);
        }
        return text;
    }

    public static void unzipFile(String source, String destDir) {
        unzipFile(new File(source), destDir);
    }

    public static void unzipFile(File file, String destDir) {
        InputStream inputStream = null;
        GzipCompressorInputStream gzipCompressorInputStream = null;
        TarArchiveInputStream tarArchiveInputStream = null;
        try {
            ValidateUtils.isTrue(file.exists(), "文件不存在！");
            inputStream = new FileInputStream(file);
            gzipCompressorInputStream = new GzipCompressorInputStream(inputStream);
            tarArchiveInputStream = new TarArchiveInputStream(gzipCompressorInputStream);

            while (true) {
                TarArchiveEntry tarArchiveEntry = tarArchiveInputStream.getNextTarEntry();
                if (tarArchiveEntry == null) {
                    break;
                }

                if (tarArchiveEntry.isDirectory()) {
                    FileUtils.createDirectoryIfNotExists(destDir + File.separator + tarArchiveEntry.getName());
                } else {
                    File fileEntry = new File(destDir + File.separator + tarArchiveEntry.getName());
                    FileUtils.createDirectoryIfNotExists(fileEntry.getParentFile());
                    IOUtils.copy(tarArchiveInputStream, new FileOutputStream(file), true);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.close(tarArchiveInputStream);
            IOUtils.close(gzipCompressorInputStream);
            IOUtils.close(inputStream);
        }
    }
}
