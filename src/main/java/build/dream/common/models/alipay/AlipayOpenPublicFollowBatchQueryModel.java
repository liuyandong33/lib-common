package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class AlipayOpenPublicFollowBatchQueryModel extends AlipayBasicModel {
    @Length(max = 32)
    @JsonProperty(value = "next_user_id")
    private String nextUserId;

    public String getNextUserId() {
        return nextUserId;
    }

    public void setNextUserId(String nextUserId) {
        this.nextUserId = nextUserId;
    }

    public static class Builder {
        private final AlipayOpenPublicFollowBatchQueryModel instance = new AlipayOpenPublicFollowBatchQueryModel();

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

        public Builder nextUserId(String nextUserId) {
            instance.setNextUserId(nextUserId);
            return this;
        }

        public AlipayOpenPublicFollowBatchQueryModel build() {
            AlipayOpenPublicFollowBatchQueryModel alipayOpenPublicFollowBatchQueryModel = new AlipayOpenPublicFollowBatchQueryModel();
            alipayOpenPublicFollowBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicFollowBatchQueryModel.setBranchId(instance.getBranchId());
            alipayOpenPublicFollowBatchQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicFollowBatchQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicFollowBatchQueryModel.setAuthToken(instance.getAuthToken());
            alipayOpenPublicFollowBatchQueryModel.setNextUserId(instance.getNextUserId());
            return alipayOpenPublicFollowBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}