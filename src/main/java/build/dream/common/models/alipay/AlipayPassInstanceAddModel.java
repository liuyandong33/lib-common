package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayPassInstanceAddModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 999)
    @JsonProperty(value = "tpl_id")
    private String tplId;

    @NotNull
    @Length(max = 99999)
    @JsonProperty(value = "tpl_params")
    private String tplParams;

    @NotNull
    @InList(value = {"1"})
    @JsonProperty(value = "recognition_type")
    private String recognitionType;

    @NotNull
    @Length(max = 999)
    @JsonProperty(value = "recognition_info")
    private String recognitionInfo;

    public String getTplId() {
        return tplId;
    }

    public void setTplId(String tplId) {
        this.tplId = tplId;
    }

    public String getTplParams() {
        return tplParams;
    }

    public void setTplParams(String tplParams) {
        this.tplParams = tplParams;
    }

    public String getRecognitionType() {
        return recognitionType;
    }

    public void setRecognitionType(String recognitionType) {
        this.recognitionType = recognitionType;
    }

    public String getRecognitionInfo() {
        return recognitionInfo;
    }

    public void setRecognitionInfo(String recognitionInfo) {
        this.recognitionInfo = recognitionInfo;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayPassInstanceAddModel> {
        public Builder tplId(String tplId) {
            instance.setTplId(tplId);
            return this;
        }

        public Builder tplParams(String tplParams) {
            instance.setTplParams(tplParams);
            return this;
        }

        public Builder recognitionType(String recognitionType) {
            instance.setRecognitionType(recognitionType);
            return this;
        }

        public Builder recognitionInfo(String recognitionInfo) {
            instance.setRecognitionInfo(recognitionInfo);
            return this;
        }

        @Override
        public AlipayPassInstanceAddModel build() {
            AlipayPassInstanceAddModel alipayPassInstanceAddModel = super.build();
            alipayPassInstanceAddModel.setTplId(instance.getTplId());
            alipayPassInstanceAddModel.setTplParams(instance.getTplParams());
            alipayPassInstanceAddModel.setRecognitionType(instance.getRecognitionType());
            alipayPassInstanceAddModel.setRecognitionInfo(instance.getRecognitionInfo());
            return alipayPassInstanceAddModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
