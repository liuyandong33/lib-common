package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

import java.util.Date;

public class ResponseLog extends BasicDomain {
    public static final String TABLE_NAME = "response_log";
    /**
     * 唯一标识
     */
    private String uuid;
    /**
     * 响应时间
     */
    private Date responseTime;
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

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
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

    public static class Builder extends BasicDomain.Builder<Builder, ResponseLog> {
        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder responseTime(Date responseTime) {
            instance.setResponseTime(responseTime);
            return this;
        }

        public Builder responseContent(String responseContent) {
            instance.setResponseContent(responseContent);
            return this;
        }

        public Builder headers(String headers) {
            instance.setHeaders(headers);
            return this;
        }

        @Override
        public ResponseLog build() {
            ResponseLog responseLog = super.build();
            responseLog.setUuid(instance.getUuid());
            responseLog.setResponseTime(instance.getResponseTime());
            responseLog.setResponseContent(instance.getResponseContent());
            responseLog.setHeaders(instance.getHeaders());
            return responseLog;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String UUID = "uuid";
        public static final String RESPONSE_TIME = "response_time";
        public static final String RESPONSE_CONTENT = "response_content";
        public static final String HEADERS = "headers";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String UUID = "uuid";
        public static final String RESPONSE_TIME = "responseTime";
        public static final String RESPONSE_CONTENT = "responseContent";
        public static final String HEADERS = "headers";
    }
}
