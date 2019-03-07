package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayPassTemplateUpdateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 999)
    @JsonProperty(value = "tpl_id")
    private String tplId;

    @NotNull
    @Length(max = 99999)
    @JsonProperty(value = "tpl_content")
    private String tplContent;

    public String getTplId() {
        return tplId;
    }

    public void setTplId(String tplId) {
        this.tplId = tplId;
    }

    public String getTplContent() {
        return tplContent;
    }

    public void setTplContent(String tplContent) {
        this.tplContent = tplContent;
    }

    public static class Builder {
        private final AlipayPassTemplateUpdateModel instance = new AlipayPassTemplateUpdateModel();

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

        public Builder tplId(String tplId) {
            instance.setTplId(tplId);
            return this;
        }

        public Builder tplContent(String tplContent) {
            instance.setTplContent(tplContent);
            return this;
        }

        public AlipayPassTemplateUpdateModel build() {
            AlipayPassTemplateUpdateModel alipayPassTemplateUpdateModel = new AlipayPassTemplateUpdateModel();
            alipayPassTemplateUpdateModel.setTenantId(instance.getTenantId());
            alipayPassTemplateUpdateModel.setBranchId(instance.getBranchId());
            alipayPassTemplateUpdateModel.setReturnUrl(instance.getReturnUrl());
            alipayPassTemplateUpdateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayPassTemplateUpdateModel.setAuthToken(instance.getAuthToken());
            alipayPassTemplateUpdateModel.setTplId(instance.getTplId());
            alipayPassTemplateUpdateModel.setTplContent(instance.getTplContent());
            return alipayPassTemplateUpdateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
