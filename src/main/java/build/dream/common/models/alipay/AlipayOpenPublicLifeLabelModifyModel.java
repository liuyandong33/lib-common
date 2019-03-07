package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicLifeLabelModifyModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "label_id")
    private String labelId;

    @NotNull
    @Length(max = 30)
    @JsonProperty(value = "label_name")
    private String labelName;

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public static class Builder {
        private final AlipayOpenPublicLifeLabelModifyModel instance = new AlipayOpenPublicLifeLabelModifyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicLifeLabelModifyModel build() {
            AlipayOpenPublicLifeLabelModifyModel alipayOpenPublicLifeLabelModifyModel = new AlipayOpenPublicLifeLabelModifyModel();
            alipayOpenPublicLifeLabelModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeLabelModifyModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicLifeLabelModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
