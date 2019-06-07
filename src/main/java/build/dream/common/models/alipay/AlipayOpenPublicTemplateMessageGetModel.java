package build.dream.common.models.alipay;

public class AlipayOpenPublicTemplateMessageGetModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicTemplateMessageGetModel> {
        @Override
        public AlipayOpenPublicTemplateMessageGetModel build() {
            AlipayOpenPublicTemplateMessageGetModel alipayOpenPublicTemplateMessageGetModel = super.build();
            return alipayOpenPublicTemplateMessageGetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
