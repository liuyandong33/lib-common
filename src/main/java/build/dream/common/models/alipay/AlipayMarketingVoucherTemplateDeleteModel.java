package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingVoucherTemplateDeleteModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "template_id")
    private String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public static class Builder {
        private final AlipayMarketingVoucherTemplateDeleteModel instance = new AlipayMarketingVoucherTemplateDeleteModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder templateId(String templateId) {
            instance.setTemplateId(templateId);
            return this;
        }

        public AlipayMarketingVoucherTemplateDeleteModel build() {
            AlipayMarketingVoucherTemplateDeleteModel alipayMarketingVoucherTemplateDeleteModel = new AlipayMarketingVoucherTemplateDeleteModel();
            alipayMarketingVoucherTemplateDeleteModel.setTenantId(instance.getTenantId());
            alipayMarketingVoucherTemplateDeleteModel.setBranchId(instance.getBranchId());
            alipayMarketingVoucherTemplateDeleteModel.setTemplateId(instance.getTemplateId());
            return alipayMarketingVoucherTemplateDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
