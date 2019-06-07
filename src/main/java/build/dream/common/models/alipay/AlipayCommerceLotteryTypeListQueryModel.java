package build.dream.common.models.alipay;

public class AlipayCommerceLotteryTypeListQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayCommerceLotteryTypeListQueryModel> {
        @Override
        public AlipayCommerceLotteryTypeListQueryModel build() {
            AlipayCommerceLotteryTypeListQueryModel alipayCommerceLotteryTypeListQueryModel = super.build();
            return alipayCommerceLotteryTypeListQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
