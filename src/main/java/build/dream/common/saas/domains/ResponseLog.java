package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
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

    public static class Builder {
        private final ResponseLog instance = new ResponseLog();

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

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public ResponseLog build() {
            ResponseLog responseLog = new ResponseLog();
            responseLog.setUuid(instance.getUuid());
            responseLog.setResponseTime(instance.getResponseTime());
            responseLog.setResponseContent(instance.getResponseContent());
            responseLog.setHeaders(instance.getHeaders());
            responseLog.setId(instance.getId());
            responseLog.setCreatedTime(instance.getCreatedTime());
            responseLog.setCreatedUserId(instance.getCreatedUserId());
            responseLog.setUpdatedTime(instance.getUpdatedTime());
            responseLog.setUpdatedUserId(instance.getUpdatedUserId());
            responseLog.setUpdatedRemark(instance.getUpdatedRemark());
            responseLog.setDeletedTime(instance.getDeletedTime());
            responseLog.setDeleted(instance.isDeleted());
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
