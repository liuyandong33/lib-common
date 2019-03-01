package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicTemplateMessageIndustryModifyModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 30)
    @JsonProperty(value = "primary_industry_name")
    private String primaryIndustryName;

    @NotNull
    @Length(max = 20)
    @JsonProperty(value = "primary_industry_code")
    private String primaryIndustryCode;

    @NotNull
    @Length(max = 20)
    @JsonProperty(value = "secondary_industry_code")
    private String secondaryIndustryCode;

    @NotNull
    @Length(max = 30)
    @JsonProperty(value = "secondary_industry_name")
    private String secondaryIndustryName;

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

    public String getPrimaryIndustryName() {
        return primaryIndustryName;
    }

    public void setPrimaryIndustryName(String primaryIndustryName) {
        this.primaryIndustryName = primaryIndustryName;
    }

    public String getPrimaryIndustryCode() {
        return primaryIndustryCode;
    }

    public void setPrimaryIndustryCode(String primaryIndustryCode) {
        this.primaryIndustryCode = primaryIndustryCode;
    }

    public String getSecondaryIndustryCode() {
        return secondaryIndustryCode;
    }

    public void setSecondaryIndustryCode(String secondaryIndustryCode) {
        this.secondaryIndustryCode = secondaryIndustryCode;
    }

    public String getSecondaryIndustryName() {
        return secondaryIndustryName;
    }

    public void setSecondaryIndustryName(String secondaryIndustryName) {
        this.secondaryIndustryName = secondaryIndustryName;
    }

    public static class Builder {
        private final AlipayOpenPublicTemplateMessageIndustryModifyModel instance = new AlipayOpenPublicTemplateMessageIndustryModifyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder primaryIndustryName(String primaryIndustryName) {
            instance.setPrimaryIndustryName(primaryIndustryName);
            return this;
        }

        public Builder primaryIndustryCode(String primaryIndustryCode) {
            instance.setPrimaryIndustryCode(primaryIndustryCode);
            return this;
        }

        public Builder secondaryIndustryCode(String secondaryIndustryCode) {
            instance.setSecondaryIndustryCode(secondaryIndustryCode);
            return this;
        }

        public Builder secondaryIndustryName(String secondaryIndustryName) {
            instance.setSecondaryIndustryName(secondaryIndustryName);
            return this;
        }

        public AlipayOpenPublicTemplateMessageIndustryModifyModel build() {
            AlipayOpenPublicTemplateMessageIndustryModifyModel alipayOpenPublicTemplateMessageIndustryModifyModel = new AlipayOpenPublicTemplateMessageIndustryModifyModel();
            alipayOpenPublicTemplateMessageIndustryModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicTemplateMessageIndustryModifyModel.setBranchId(instance.getBranchId());
            alipayOpenPublicTemplateMessageIndustryModifyModel.setPrimaryIndustryName(instance.getPrimaryIndustryName());
            alipayOpenPublicTemplateMessageIndustryModifyModel.setPrimaryIndustryCode(instance.getPrimaryIndustryCode());
            alipayOpenPublicTemplateMessageIndustryModifyModel.setSecondaryIndustryCode(instance.getSecondaryIndustryCode());
            alipayOpenPublicTemplateMessageIndustryModifyModel.setSecondaryIndustryName(instance.getSecondaryIndustryName());
            return alipayOpenPublicTemplateMessageIndustryModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}