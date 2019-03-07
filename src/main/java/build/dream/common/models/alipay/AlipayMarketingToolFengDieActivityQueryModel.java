package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingToolFengDieActivityQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 11)
    @JsonProperty(value = "activity_id")
    private String activityId;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public static class Builder {
        private final AlipayMarketingToolFengDieActivityQueryModel instance = new AlipayMarketingToolFengDieActivityQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder activityId(String activityId) {
            instance.setActivityId(activityId);
            return this;
        }

        public AlipayMarketingToolFengDieActivityQueryModel build() {
            AlipayMarketingToolFengDieActivityQueryModel alipayMarketingToolFengDieActivityQueryModel = new AlipayMarketingToolFengDieActivityQueryModel();
            alipayMarketingToolFengDieActivityQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingToolFengDieActivityQueryModel.setBranchId(instance.getBranchId());
            alipayMarketingToolFengDieActivityQueryModel.setActivityId(instance.getActivityId());
            return alipayMarketingToolFengDieActivityQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
