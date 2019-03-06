package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingToolPointsQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "activity_account")
    private String activityAccount;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "user_id")
    private String userId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchId() {
        return branchId;
    }

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
            koubeiMarketingToolPointsQueryModel.setActivityAccount(instance.getActivityAccount());
            koubeiMarketingToolPointsQueryModel.setUserId(instance.getUserId());
            return koubeiMarketingToolPointsQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
