package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingVoucherTemplateDetailQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 28)
    @JsonProperty(value = "template_id")
    private String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public static class Builder {
        private final AlipayMarketingVoucherTemplateDetailQueryModel instance = new AlipayMarketingVoucherTemplateDetailQueryModel();

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

        public Builder templateId(String templateId) {
            instance.setTemplateId(templateId);
            return this;
        }

        public AlipayMarketingVoucherTemplateDetailQueryModel build() {
            AlipayMarketingVoucherTemplateDetailQueryModel alipayMarketingVoucherTemplateDetailQueryModel = new AlipayMarketingVoucherTemplateDetailQueryModel();
            alipayMarketingVoucherTemplateDetailQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingVoucherTemplateDetailQueryModel.setBranchId(instance.getBranchId());
            alipayMarketingVoucherTemplateDetailQueryModel.setTemplateId(instance.getTemplateId());
            return alipayMarketingVoucherTemplateDetailQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
