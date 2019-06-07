package build.dream.common.models.alipay;

public class ZolozAuthenticationCustomerSmilePayInitializeModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, ZolozAuthenticationCustomerSmilePayInitializeModel> {
        @Override
        public ZolozAuthenticationCustomerSmilePayInitializeModel build() {
            ZolozAuthenticationCustomerSmilePayInitializeModel zolozAuthenticationCustomerSmilePayInitializeModel = super.build();
            return zolozAuthenticationCustomerSmilePayInitializeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
