package build.dream.common.beans;

import build.dream.common.constants.Constants;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebResult {
    private InputStream inputStream;
    private Map<String, List<String>> headers = new HashMap<String, List<String>>();
    private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
    private int responseCode;

    public WebResult() {

    }

    public WebResult(InputStream result, Map<String, List<String>> headers, int responseCode) {
        this.inputStream = result;
        this.responseCode = responseCode;
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
            this.headers.put(header.getKey(), header.getValue());
        }
    }

    public InputStream getResult() {
        return inputStream;
    }

    public void setResult(InputStream result) {
        this.inputStream = result;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public Map<String, Cookie> getCookieMap() {
        return cookieMap;
    }

    public void setCookieMap(Map<String, Cookie> cookieMap) {
        this.cookieMap = cookieMap;
    }

    public String stringResult() throws IOException {
        return IOUtils.toString(inputStream, Constants.CHARSET_UTF_8);
    }
}
