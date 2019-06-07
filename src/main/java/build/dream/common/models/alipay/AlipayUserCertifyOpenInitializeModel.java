package build.dream.common.models.alipay;

public class AlipayUserCertifyOpenInitializeModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayUserCertifyOpenInitializeModel> {
        @Override
        public AlipayUserCertifyOpenInitializeModel build() {
            AlipayUserCertifyOpenInitializeModel alipayUserCertifyOpenInitializeModel = super.build();
            return alipayUserCertifyOpenInitializeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
