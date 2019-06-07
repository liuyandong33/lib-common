package build.dream.common.models.alipay;

public class AlipayEbppPdeductSignValidateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayEbppPdeductSignValidateModel> {
        @Override
        public AlipayEbppPdeductSignValidateModel build() {
            AlipayEbppPdeductSignValidateModel alipayEbppPdeductSignValidateModel = super.build();
            return alipayEbppPdeductSignValidateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
