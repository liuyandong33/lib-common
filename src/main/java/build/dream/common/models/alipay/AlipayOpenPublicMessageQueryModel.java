package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class AlipayOpenPublicMessageQueryModel extends AlipayBasicModel {
    @NotEmpty
    @Size(max = 20)
    @JsonProperty(value = "message_ids")
    private List<String> messageIds;

    public List<String> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<String> messageIds) {
        this.messageIds = messageIds;
    }

    public static class Builder {
        private final AlipayOpenPublicMessageQueryModel instance = new AlipayOpenPublicMessageQueryModel();

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

        public Builder messageIds(List<String> messageIds) {
            instance.setMessageIds(messageIds);
            return this;
        }

        public AlipayOpenPublicMessageQueryModel build() {
            AlipayOpenPublicMessageQueryModel alipayOpenPublicMessageQueryModel = new AlipayOpenPublicMessageQueryModel();
            alipayOpenPublicMessageQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMessageQueryModel.setBranchId(instance.getBranchId());
            alipayOpenPublicMessageQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicMessageQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicMessageQueryModel.setAuthToken(instance.getAuthToken());
            alipayOpenPublicMessageQueryModel.setMessageIds(instance.getMessageIds());
            return alipayOpenPublicMessageQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
