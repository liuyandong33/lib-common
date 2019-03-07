package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicLifeLabelCreateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 30)
    @JsonProperty(value = "label_name")
    private String labelName;

    @InList(value = {"string"})
    @JsonProperty(value = "data_type")
    private String dataType;

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public static class Builder {
        private final AlipayOpenPublicLifeLabelCreateModel instance = new AlipayOpenPublicLifeLabelCreateModel();

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

        public Builder labelName(String labelName) {
            instance.setLabelName(labelName);
            return this;
        }

        public Builder dataType(String dataType) {
            instance.setDataType(dataType);
            return this;
        }

        public AlipayOpenPublicLifeLabelCreateModel build() {
            AlipayOpenPublicLifeLabelCreateModel alipayOpenPublicLifeLabelCreateModel = new AlipayOpenPublicLifeLabelCreateModel();
            alipayOpenPublicLifeLabelCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeLabelCreateModel.setBranchId(instance.getBranchId());
            alipayOpenPublicLifeLabelCreateModel.setLabelName(instance.getLabelName());
            alipayOpenPublicLifeLabelCreateModel.setDataType(instance.getDataType());
            return alipayOpenPublicLifeLabelCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
