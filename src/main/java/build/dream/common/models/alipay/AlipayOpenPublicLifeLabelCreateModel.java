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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicLifeLabelCreateModel instance = new AlipayOpenPublicLifeLabelCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
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
            build(alipayOpenPublicLifeLabelCreateModel);
            alipayOpenPublicLifeLabelCreateModel.setLabelName(instance.getLabelName());
            alipayOpenPublicLifeLabelCreateModel.setDataType(instance.getDataType());
            return alipayOpenPublicLifeLabelCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
