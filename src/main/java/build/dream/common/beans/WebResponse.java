package build.dream.common.beans;

import java.util.List;
import java.util.Map;

public class WebResponse {
    private String result;
    private Map<String, List<String>> headers;

    public WebResponse() {

    }

    public WebResponse(String result, Map<String, List<String>> headers) {
        this.result = result;
        this.headers = headers;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }
}
