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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicLifeLabelDeleteModel instance = new AlipayOpenPublicLifeLabelDeleteModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder labelId(String labelId) {
            instance.setLabelId(labelId);
            return this;
        }

        public AlipayOpenPublicLifeLabelDeleteModel build() {
            AlipayOpenPublicLifeLabelDeleteModel alipayOpenPublicLifeLabelDeleteModel = new AlipayOpenPublicLifeLabelDeleteModel();
            build(alipayOpenPublicLifeLabelDeleteModel);
            alipayOpenPublicLifeLabelDeleteModel.setLabelId(instance.getLabelId());
            return alipayOpenPublicLifeLabelDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
