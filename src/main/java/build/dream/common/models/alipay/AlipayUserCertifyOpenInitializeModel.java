package build.dream.common.models.alipay;

public class AlipayUserCertifyOpenInitializeModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayUserCertifyOpenInitializeModel instance = new AlipayUserCertifyOpenInitializeModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayUserCertifyOpenInitializeModel build() {
            AlipayUserCertifyOpenInitializeModel alipayUserCertifyOpenInitializeModel = new AlipayUserCertifyOpenInitializeModel();
            build(alipayUserCertifyOpenInitializeModel);
            return alipayUserCertifyOpenInitializeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
