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

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicLifeLabelModifyModel> {
        public Builder labelId(String labelId) {
            instance.setLabelId(labelId);
            return this;
        }

        public Builder labelName(String labelName) {
            instance.setLabelName(labelName);
            return this;
        }

        @Override
        public AlipayOpenPublicLifeLabelModifyModel build() {
            AlipayOpenPublicLifeLabelModifyModel alipayOpenPublicLifeLabelModifyModel = super.build();
            alipayOpenPublicLifeLabelModifyModel.setLabelId(instance.getLabelId());
            alipayOpenPublicLifeLabelModifyModel.setLabelName(instance.getLabelName());
            return alipayOpenPublicLifeLabelModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
