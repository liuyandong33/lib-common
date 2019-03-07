package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingToolPointsQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "activity_account")
    private String activityAccount;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "user_id")
    private String userId;

    public String getActivityAccount() {
        return activityAccount;
    }

    public void setActivityAccount(String activityAccount) {
        this.activityAccount = activityAccount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class Builder {
        private final KoubeiMarketingToolPointsQueryModel instance = new KoubeiMarketingToolPointsQueryModel();

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

        public Builder activityAccount(String activityAccount) {
            instance.setActivityAccount(activityAccount);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public KoubeiMarketingToolPointsQueryModel build() {
            KoubeiMarketingToolPointsQueryModel koubeiMarketingToolPointsQueryModel = new KoubeiMarketingToolPointsQueryModel();
            koubeiMarketingToolPointsQueryModel.setTenantId(instance.getTenantId());
            koubeiMarketingToolPointsQueryModel.setBranchId(instance.getBranchId());
            koubeiMarketingToolPointsQueryModel.setReturnUrl(instance.getReturnUrl());
            koubeiMarketingToolPointsQueryModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiMarketingToolPointsQueryModel.setAuthToken(instance.getAuthToken());
            koubeiMarketingToolPointsQueryModel.setActivityAccount(instance.getActivityAccount());
            koubeiMarketingToolPointsQueryModel.setUserId(instance.getUserId());
            return koubeiMarketingToolPointsQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
