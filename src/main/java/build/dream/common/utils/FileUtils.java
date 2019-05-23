package build.dream.common.utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
    public static void createDirectoryIfNotExists(String path) {
        createDirectoryIfNotExists(new File(path));
    }

    public static void createDirectoryIfNotExists(File directory) {
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public static void download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, File file, boolean acceptRanges) {
        long fileLength = file.length();
        String fileName = file.getName();

        httpServletResponse.setContentType(MimeMappingUtils.obtainMimeTypeByFileName(fileName));
        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        httpServletResponse.setHeader("Content-Length", String.valueOf(fileLength));

        long start = 0;
        long end = 0;

        if (acceptRanges) {
            end = fileLength - 1;
        } else {
            httpServletResponse.setHeader("Accept-Ranges", "bytes");
            String range = httpServletRequest.getHeader("Range");
            if (StringUtils.isNotBlank(range)) {
                httpServletResponse.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                range = range.substring(6);
                if (range.indexOf("-") == range.length() - 1) {
                    start = Long.parseLong(range);
                    end = fileLength - 1;
                } else if (range.indexOf("-") == 0) {
                    long length = Long.parseLong(range.substring(1));
                    start = fileLength - length;
                    end = fileLength - 1;
                } else {
                    String[] array = range.split("-");
                    start = Long.parseLong(array[0]);
                    end = Long.parseLong(array[1]);
                }

                httpServletResponse.setHeader("Content-Range", "bytes " + start + "-" + end + "/" + fileLength);
            } else {
                start = 0;
                end = fileLength - 1;
            }
        }
        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = httpServletResponse.getOutputStream();
        ) {
            inputStream.skip(start);
            long count = (end - start + 1) / 1024;
            int remainder = (int) ((end - start + 1) % 1024);
            byte[] buffer = new byte[1024];
            int length = 0;
            for (long index = 0; index < count; index++) {
                length = inputStream.read(buffer, 0, 1024);
                outputStream.write(buffer, 0, length);
                outputStream.flush();
            }

            if (remainder > 0) {
                inputStream.read(buffer, 0, remainder);
                outputStream.write(buffer, 0, remainder);
                outputStream.flush();
            }
        } catch (Exception e) {

        }
    }
}
