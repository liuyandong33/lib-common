package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class ElemeCallbackMessage extends BasicDomain {
    private String requestId;
    private Integer type;
    private BigInteger appId;
    private String message;
    private BigInteger shopId;
    private BigInteger timestamp;
    private String signature;
    private BigInteger userId;
    private String uuid;
    private Integer handleResult;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigInteger getAppId() {
        return appId;
    }

    public void setAppId(BigInteger appId) {
        this.appId = appId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigInteger getShopId() {
        return shopId;
    }

    public void setShopId(BigInteger shopId) {
        this.shopId = shopId;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(Integer handleResult) {
        this.handleResult = handleResult;
    }

    public static class Builder {
        private final ElemeCallbackMessage instance = new ElemeCallbackMessage();

        public Builder requestId(String requestId) {
            instance.setRequestId(requestId);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder appId(BigInteger appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder message(String message) {
            instance.setMessage(message);
            return this;
        }

        public Builder shopId(BigInteger shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public Builder timestamp(BigInteger timestamp) {
            instance.setTimestamp(timestamp);
            return this;
        }

        public Builder signature(String signature) {
            instance.setSignature(signature);
            return this;
        }

        public Builder userId(BigInteger userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder handleResult(Integer handleResult) {
            instance.setHandleResult(handleResult);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public ElemeCallbackMessage build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String REQUEST_ID = "request_id";
        public static final String TYPE = "type";
        public static final String APP_ID = "app_id";
        public static final String MESSAGE = "message";
        public static final String SHOP_ID = "shop_id";
        public static final String TIMESTAMP = "timestamp";
        public static final String SIGNATURE = "signature";
        public static final String USER_ID = "user_id";
        public static final String UUID = "uuid";
        public static final String HANDLE_RESULT = "handle_result";
    }
}
