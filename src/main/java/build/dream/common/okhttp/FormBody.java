package build.dream.common.okhttp;

import build.dream.common.utils.WebUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import org.apache.commons.collections.MapUtils;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Map;

public final class FormBody extends RequestBody {
    private Map<String, String> requestParameters;
    private String charsetName;

    public FormBody(Map<String, String> requestParameters, String charsetName) {
        this.requestParameters = requestParameters;
        this.charsetName = charsetName;
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return MediaType.parse("application/x-www-form-urlencoded;charset=" + charsetName);
    }

    @Override
    public long contentLength() throws IOException {
        return MapUtils.isEmpty(requestParameters) ? 0 : WebUtils.buildRequestBody(requestParameters, charsetName).getBytes(charsetName).length;
    }

    @Override
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (MapUtils.isEmpty(requestParameters)) {
            return;
        }
        bufferedSink.write(WebUtils.buildRequestBody(requestParameters, charsetName).getBytes(charsetName));
    }
}
