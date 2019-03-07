package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicLifeLabelDeleteModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "label_id")
    private String labelId;

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
