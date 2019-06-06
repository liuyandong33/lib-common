package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicPersonalizedExtensionDeleteModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "extension_key")
    private String extensionKey;

    public String getExtensionKey() {
        return extensionKey;
    }

    public void setExtensionKey(String extensionKey) {
        this.extensionKey = extensionKey;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicPersonalizedExtensionDeleteModel instance = new AlipayOpenPublicPersonalizedExtensionDeleteModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder extensionKey(String extensionKey) {
            instance.setExtensionKey(extensionKey);
            return this;
        }

        public AlipayOpenPublicPersonalizedExtensionDeleteModel build() {
            AlipayOpenPublicPersonalizedExtensionDeleteModel alipayOpenPublicPersonalizedExtensionDeleteModel = new AlipayOpenPublicPersonalizedExtensionDeleteModel();
            build(alipayOpenPublicPersonalizedExtensionDeleteModel);
            alipayOpenPublicPersonalizedExtensionDeleteModel.setExtensionKey(instance.getExtensionKey());
            return alipayOpenPublicPersonalizedExtensionDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
