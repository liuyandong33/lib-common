package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingToolFengDieEditorQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 11)
    @JsonProperty(value = "activity_id")
    private String activityId;

    @NotNull
    @Length(max = 500)
    @JsonProperty(value = "redirect_url")
    private String redirectUrl;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public static class Builder {
        private final AlipayMarketingToolFengDieEditorQueryModel instance = new AlipayMarketingToolFengDieEditorQueryModel();

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

        public Builder redirectUrl(String redirectUrl) {
            instance.setRedirectUrl(redirectUrl);
            return this;
        }

        public AlipayMarketingToolFengDieEditorQueryModel build() {
            AlipayMarketingToolFengDieEditorQueryModel alipayMarketingToolFengDieEditorQueryModel = new AlipayMarketingToolFengDieEditorQueryModel();
            alipayMarketingToolFengDieEditorQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingToolFengDieEditorQueryModel.setBranchId(instance.getBranchId());
            alipayMarketingToolFengDieEditorQueryModel.setActivityId(instance.getActivityId());
            alipayMarketingToolFengDieEditorQueryModel.setRedirectUrl(instance.getRedirectUrl());
            return alipayMarketingToolFengDieEditorQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
