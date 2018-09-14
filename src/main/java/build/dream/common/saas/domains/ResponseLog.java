package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class ResponseLog extends BasicDomain {
    /**
     * 唯一标识
     */
    private String uuid;
    /**
     * 响应体
     */
    private String responseContent;
    /**
     * 请求头
     */
    private String headers;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }
}
