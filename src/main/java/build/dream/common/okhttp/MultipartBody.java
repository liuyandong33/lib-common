package build.dream.common.okhttp;

import build.dream.common.constants.Constants;
import build.dream.common.utils.MimeMappingUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import org.apache.commons.collections.MapUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MultipartBody extends RequestBody {
    private static final String TWO_HYPHENS = "--";
    private static final String ENTER_NEW_LINE = "\r\n";
    private Map<String, Object> parts;
    private String charsetName;
    private String boundary;

    public MultipartBody(Map<String, Object> parts, String charsetName) {
        this.parts = parts;
        this.charsetName = charsetName;
        this.boundary = UUID.randomUUID().toString();
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return MediaType.parse("multipart/form-data;boundary=" + boundary + ";charset=" + charsetName);
    }

    @Override
    public long contentLength() throws IOException {
        if (MapUtils.isEmpty(parts)) {
            return 0;
        }

        long contentLength = 0;
        Set<Map.Entry<String, Object>> entries = parts.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            contentLength += (TWO_HYPHENS + boundary + ENTER_NEW_LINE).getBytes(charsetName).length;
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                contentLength += ("Content-Disposition: form-data; name=\"" + key + "\"" + ENTER_NEW_LINE + ENTER_NEW_LINE).getBytes(charsetName).length;
                contentLength += value.toString().getBytes(charsetName).length;
            } else if (value instanceof MultipartFile || value instanceof File) {
                String fileName = null;
                if (value instanceof MultipartFile) {
                    MultipartFile multipartFile = (MultipartFile) value;
                    fileName = multipartFile.getOriginalFilename();
                    contentLength += multipartFile.getSize();
                } else if (value instanceof File) {
                    File file = (File) value;
                    fileName = file.getName();
                    contentLength += file.length();
                }
                contentLength += ("Content-Disposition: form-data; " + "name=\"" + key + "\";filename=\"" + fileName + "\"" + ENTER_NEW_LINE).getBytes(charsetName).length;
                contentLength += ("Content-Type:" + MimeMappingUtils.obtainMimeTypeByFileName(fileName) + ENTER_NEW_LINE + ENTER_NEW_LINE).getBytes(charsetName).length;
            }
            contentLength += ENTER_NEW_LINE.getBytes(charsetName).length;
        }
        contentLength += (TWO_HYPHENS + boundary + TWO_HYPHENS + ENTER_NEW_LINE).getBytes(charsetName).length;
        return contentLength;
    }

    @Override
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (MapUtils.isEmpty(parts)) {
            return;
        }
        Set<Map.Entry<String, Object>> entries = parts.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            bufferedSink.write((TWO_HYPHENS + boundary + ENTER_NEW_LINE).getBytes(charsetName));
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                bufferedSink.write(("Content-Disposition: form-data; name=\"" + key + "\"" + ENTER_NEW_LINE + ENTER_NEW_LINE).getBytes(charsetName));
                bufferedSink.write(value.toString().getBytes(charsetName));
            } else if (value instanceof MultipartFile || value instanceof File) {
                InputStream inputStream = null;
                String fileName = null;
                if (value instanceof MultipartFile) {
                    MultipartFile multipartFile = (MultipartFile) value;
                    inputStream = multipartFile.getInputStream();
                    fileName = multipartFile.getOriginalFilename();
                } else if (value instanceof File) {
                    File file = (File) value;
                    inputStream = new FileInputStream(file);
                    fileName = file.getName();
                }
                bufferedSink.write(("Content-Disposition: form-data; " + "name=\"" + key + "\";filename=\"" + fileName + "\"" + ENTER_NEW_LINE).getBytes(Constants.CHARSET_NAME_UTF_8));
                bufferedSink.write(("Content-Type:" + MimeMappingUtils.obtainMimeTypeByFileName(fileName) + ENTER_NEW_LINE + ENTER_NEW_LINE).getBytes(Constants.CHARSET_NAME_UTF_8));
                byte[] buffer = new byte[1024];
                int length = -1;
                while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
                    bufferedSink.write(buffer, 0, length);
                }

                inputStream.close();
            }
            bufferedSink.write(ENTER_NEW_LINE.getBytes(charsetName));
        }
        bufferedSink.write((TWO_HYPHENS + boundary + TWO_HYPHENS + ENTER_NEW_LINE).getBytes(charsetName));
    }
}
