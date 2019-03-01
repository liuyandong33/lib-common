package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicLifeLabelDeleteModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "label_id")
    private String labelId;

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

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public static class Builder {
        private final AlipayOpenPublicLifeLabelDeleteModel instance = new AlipayOpenPublicLifeLabelDeleteModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicLifeLabelDeleteModel build() {
            AlipayOpenPublicLifeLabelDeleteModel alipayOpenPublicLifeLabelDeleteModel = new AlipayOpenPublicLifeLabelDeleteModel();
            alipayOpenPublicLifeLabelDeleteModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeLabelDeleteModel.setBranchId(instance.getBranchId());
            alipayOpenPublicLifeLabelDeleteModel.setLabelId(instance.getLabelId());
            return alipayOpenPublicLifeLabelDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
