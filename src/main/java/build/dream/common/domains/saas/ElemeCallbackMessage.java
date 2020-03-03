package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class ElemeCallbackMessage extends BasicDomain {
    public static final String TABLE_NAME = "eleme_callback_message";
    private String requestId;
    private Integer type;
    private Long appId;
    private String message;
    private Long shopId;
    private Long timestamp;
    private String signature;
    private Long userId;
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

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public static class Builder extends BasicDomain.Builder<Builder, ElemeCallbackMessage> {
        public Builder requestId(String requestId) {
            instance.setRequestId(requestId);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder appId(Long appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder message(String message) {
            instance.setMessage(message);
            return this;
        }

        public Builder shopId(Long shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public Builder timestamp(Long timestamp) {
            instance.setTimestamp(timestamp);
            return this;
        }

        public Builder signature(String signature) {
            instance.setSignature(signature);
            return this;
        }

        public Builder userId(Long userId) {
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

        @Override
        public ElemeCallbackMessage build() {
            ElemeCallbackMessage elemeCallbackMessage = super.build();
            elemeCallbackMessage.setRequestId(instance.getRequestId());
            elemeCallbackMessage.setType(instance.getType());
            elemeCallbackMessage.setAppId(instance.getAppId());
            elemeCallbackMessage.setMessage(instance.getMessage());
            elemeCallbackMessage.setShopId(instance.getShopId());
            elemeCallbackMessage.setTimestamp(instance.getTimestamp());
            elemeCallbackMessage.setSignature(instance.getSignature());
            elemeCallbackMessage.setUserId(instance.getUserId());
            elemeCallbackMessage.setUuid(instance.getUuid());
            elemeCallbackMessage.setHandleResult(instance.getHandleResult());
            return elemeCallbackMessage;
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

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String REQUEST_ID = "requestId";
        public static final String TYPE = "type";
        public static final String APP_ID = "appId";
        public static final String MESSAGE = "message";
        public static final String SHOP_ID = "shopId";
        public static final String TIMESTAMP = "timestamp";
        public static final String SIGNATURE = "signature";
        public static final String USER_ID = "userId";
        public static final String UUID = "uuid";
        public static final String HANDLE_RESULT = "handleResult";
    }
}
