package build.dream.common.models.alipay;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AlipayOfflineMarketShopBatchQueryModel extends AlipayBasicModel {
    @NotNull
    @Min(1)
    @Max(9999)
    private Integer pageNo;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOfflineMarketShopBatchQueryModel instance = new AlipayOfflineMarketShopBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder pageNo(Integer pageNo) {
            instance.setPageNo(pageNo);
            return this;
        }

        public AlipayOfflineMarketShopBatchQueryModel build() {
            AlipayOfflineMarketShopBatchQueryModel alipayOfflineMarketShopBatchQueryModel = new AlipayOfflineMarketShopBatchQueryModel();
            build(alipayOfflineMarketShopBatchQueryModel);
            alipayOfflineMarketShopBatchQueryModel.setPageNo(instance.getPageNo());
            return alipayOfflineMarketShopBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
