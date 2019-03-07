package build.dream.common.models.alipay;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingToolFengDieSpaceCreateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 100)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class Builder {
        private final AlipayMarketingToolFengDieSpaceCreateModel instance = new AlipayMarketingToolFengDieSpaceCreateModel();

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

        public Builder title(String title) {
            instance.setTitle(title);
            return this;
        }

        public AlipayMarketingToolFengDieSpaceCreateModel build() {
            AlipayMarketingToolFengDieSpaceCreateModel alipayMarketingToolFengDieSpaceCreateModel = new AlipayMarketingToolFengDieSpaceCreateModel();
            alipayMarketingToolFengDieSpaceCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingToolFengDieSpaceCreateModel.setBranchId(instance.getBranchId());
            alipayMarketingToolFengDieSpaceCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingToolFengDieSpaceCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingToolFengDieSpaceCreateModel.setAuthToken(instance.getAuthToken());
            alipayMarketingToolFengDieSpaceCreateModel.setTitle(instance.getTitle());
            return alipayMarketingToolFengDieSpaceCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
