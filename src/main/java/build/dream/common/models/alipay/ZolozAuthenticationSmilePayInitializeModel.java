package build.dream.common.models.alipay;

public class ZolozAuthenticationSmilePayInitializeModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, ZolozAuthenticationSmilePayInitializeModel> {
        @Override
        public ZolozAuthenticationSmilePayInitializeModel build() {
            ZolozAuthenticationSmilePayInitializeModel zolozAuthenticationSmilePayInitializeModel = super.build();
            return zolozAuthenticationSmilePayInitializeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
