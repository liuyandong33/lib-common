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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayPassTemplateUpdateModel instance = new AlipayPassTemplateUpdateModel();

        public Builder() {
            setAlipayBasicModel(instance);
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
            build(alipayPassTemplateUpdateModel);
            alipayPassTemplateUpdateModel.setTplId(instance.getTplId());
            alipayPassTemplateUpdateModel.setTplContent(instance.getTplContent());
            return alipayPassTemplateUpdateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
