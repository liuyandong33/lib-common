package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.util.List;
import java.util.Map;

public class ResponseLog extends BasicDomain {
    /**
     * 唯一标识
     */
    private String uuid;
    /**
     * 响应体
     */
    private String responseBody;
    /**
     * 请求头
     */
    private Map<String, List<String>> headers;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }
}
