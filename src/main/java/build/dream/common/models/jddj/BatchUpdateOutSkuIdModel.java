package build.dream.common.models.jddj;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BatchUpdateOutSkuIdModel extends JDDJBasicModel {
    private List<SkuInfo> skuInfoList;

    public List<SkuInfo> getSkuInfoList() {
        return skuInfoList;
    }

    public void setSkuInfoList(List<SkuInfo> skuInfoList) {
        this.skuInfoList = skuInfoList;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, BatchUpdateOutSkuIdModel> {
        public Builder skuInfoList(List<SkuInfo> skuInfoList) {
            instance.setSkuInfoList(skuInfoList);
            return this;
        }

        @Override
        public BatchUpdateOutSkuIdModel build() {
            BatchUpdateOutSkuIdModel batchUpdateOutSkuIdModel = super.build();
            batchUpdateOutSkuIdModel.setSkuInfoList(instance.getSkuInfoList());
            return batchUpdateOutSkuIdModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class SkuInfo extends BasicModel {
        /**
         * 到家商品编码
         */
        @NotNull
        private Long skuId;

        /**
         * 商家商品编码
         */
        private String outSkuId;

        public Long getSkuId() {
            return skuId;
        }

        public void setSkuId(Long skuId) {
            this.skuId = skuId;
        }

        public String getOutSkuId() {
            return outSkuId;
        }

        public void setOutSkuId(String outSkuId) {
            this.outSkuId = outSkuId;
        }
    }
}
