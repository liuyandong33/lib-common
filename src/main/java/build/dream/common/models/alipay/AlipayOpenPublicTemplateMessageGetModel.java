package build.dream.common.models.alipay;

public class AlipayOpenPublicTemplateMessageGetModel extends AlipayBasicModel {
    public static class Builder  extends AlipayBasicModel.Builder<Builder>{
        private final AlipayOpenPublicTemplateMessageGetModel instance = new AlipayOpenPublicTemplateMessageGetModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicTemplateMessageGetModel build() {
            AlipayOpenPublicTemplateMessageGetModel alipayOpenPublicTemplateMessageGetModel = new AlipayOpenPublicTemplateMessageGetModel();
            build(alipayOpenPublicTemplateMessageGetModel);
            return alipayOpenPublicTemplateMessageGetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
