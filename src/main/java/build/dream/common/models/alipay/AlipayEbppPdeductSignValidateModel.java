package build.dream.common.models.alipay;

public class AlipayEbppPdeductSignValidateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayEbppPdeductSignValidateModel instance = new AlipayEbppPdeductSignValidateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayEbppPdeductSignValidateModel build() {
            AlipayEbppPdeductSignValidateModel alipayEbppPdeductSignValidateModel = new AlipayEbppPdeductSignValidateModel();
            super.build(alipayEbppPdeductSignValidateModel);
            return alipayEbppPdeductSignValidateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
