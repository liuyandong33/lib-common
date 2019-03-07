package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicLifeMsgRecallModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "message_id")
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public static class Builder {
        private final AlipayOpenPublicLifeMsgRecallModel instance = new AlipayOpenPublicLifeMsgRecallModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder messageId(String messageId) {
            instance.setMessageId(messageId);
            return this;
        }

        public AlipayOpenPublicLifeMsgRecallModel build() {
            AlipayOpenPublicLifeMsgRecallModel alipayOpenPublicLifeMsgRecallModel = new AlipayOpenPublicLifeMsgRecallModel();
            alipayOpenPublicLifeMsgRecallModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeMsgRecallModel.setBranchId(instance.getBranchId());
            alipayOpenPublicLifeMsgRecallModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicLifeMsgRecallModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicLifeMsgRecallModel.setAuthToken(instance.getAuthToken());
            alipayOpenPublicLifeMsgRecallModel.setMessageId(instance.getMessageId());
            return alipayOpenPublicLifeMsgRecallModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
