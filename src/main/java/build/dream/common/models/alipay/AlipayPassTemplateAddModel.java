package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayPassTemplateAddModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 999)
    @JsonProperty(value = "unique_id")
    private String uniqueId;

    @NotNull
    @Length(max = 99999)
    @JsonProperty(value = "tpl_content")
    private String tplContent;

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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayPassTemplateAddModel instance = new AlipayPassTemplateAddModel();

        public Builder() {
            setAlipayBasicModel(instance);
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
            build(alipayPassTemplateAddModel);
            alipayPassTemplateAddModel.setUniqueId(instance.getUniqueId());
            alipayPassTemplateAddModel.setTplContent(instance.getTplContent());
            return alipayPassTemplateAddModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
