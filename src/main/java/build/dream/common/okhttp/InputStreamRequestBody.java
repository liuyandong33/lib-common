package build.dream.common.okhttp;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamRequestBody extends RequestBody {
    private InputStream inputStream;
    private String contentType;

    public InputStreamRequestBody(InputStream inputStream, String contentType) {
        this.inputStream = inputStream;
        this.contentType = contentType;
    }

    @Override
    public long contentLength() throws IOException {
        return inputStream.available();
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return MediaType.parse(contentType);
    }

    @Override
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
            bufferedSink.write(buffer, 0, length);
        }
    }
}
