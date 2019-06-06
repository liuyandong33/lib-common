package build.dream.common.models.alipay;

public class AlipayCommerceLotteryTypeListQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayCommerceLotteryTypeListQueryModel instance = new AlipayCommerceLotteryTypeListQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayCommerceLotteryTypeListQueryModel build() {
            AlipayCommerceLotteryTypeListQueryModel alipayCommerceLotteryTypeListQueryModel = new AlipayCommerceLotteryTypeListQueryModel();
            build(alipayCommerceLotteryTypeListQueryModel);
            return alipayCommerceLotteryTypeListQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
