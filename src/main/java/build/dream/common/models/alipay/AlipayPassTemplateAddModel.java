package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayPassTemplateAddModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 999)
    @JsonProperty(value = "unique_id")
    private String uniqueId;

    @NotNull
    @Length(max = 99999)
    @JsonProperty(value = "tpl_content")
    private String tplContent;

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

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getTplContent() {
        return tplContent;
    }

    public void setTplContent(String tplContent) {
        this.tplContent = tplContent;
    }

    public static class Builder {
        private final AlipayPassTemplateAddModel instance = new AlipayPassTemplateAddModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder uniqueId(String uniqueId) {
            instance.setUniqueId(uniqueId);
            return this;
        }

        public Builder tplContent(String tplContent) {
            instance.setTplContent(tplContent);
            return this;
        }

        public AlipayPassTemplateAddModel build() {
            AlipayPassTemplateAddModel alipayPassTemplateAddModel = new AlipayPassTemplateAddModel();
            alipayPassTemplateAddModel.setTenantId(instance.getTenantId());
            alipayPassTemplateAddModel.setBranchId(instance.getBranchId());
            alipayPassTemplateAddModel.setUniqueId(instance.getUniqueId());
            alipayPassTemplateAddModel.setTplContent(instance.getTplContent());
            return alipayPassTemplateAddModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}