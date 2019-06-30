package build.dream.common.models.jddj;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class BatchAddSkuModel extends JDDJBasicModel {
    /**
     * 请求唯一编码
     */
    @NotNull
    private String traceId;

    @NotEmpty
    private List<OpenBatchAddSkuRequest> openBatchAddSkuRequests;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public List<OpenBatchAddSkuRequest> getOpenBatchAddSkuRequests() {
        return openBatchAddSkuRequests;
    }

    public void setOpenBatchAddSkuRequests(List<OpenBatchAddSkuRequest> openBatchAddSkuRequests) {
        this.openBatchAddSkuRequests = openBatchAddSkuRequests;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, BatchAddSkuModel> {
        public Builder traceId(String traceId) {
            instance.setTraceId(traceId);
            return this;
        }

        public Builder openBatchAddSkuRequests(List<OpenBatchAddSkuRequest> openBatchAddSkuRequests) {
            instance.setOpenBatchAddSkuRequests(openBatchAddSkuRequests);
            return this;
        }

        @Override
        public BatchAddSkuModel build() {
            BatchAddSkuModel batchAddSkuModel = super.build();
            batchAddSkuModel.setTraceId(instance.getTraceId());
            batchAddSkuModel.setOpenBatchAddSkuRequests(instance.getOpenBatchAddSkuRequests());
            return batchAddSkuModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class OpenBatchAddSkuRequest extends BasicModel {
        /**
         * 商家skuId编码（商家skuId）
         */
        @NotNull
        private String outSkuId;

        /**
         * 商品唯一编码（对应商家的 UPC）
         */
        @NotNull
        private String upc;

        /**
         * 商家商品价格(单位：分)，用于初始商品门店价格，所有的商品门店价格都会初始化成该值。后续修改商品门店价格需要通过价格类接口修改
         */
        @NotNull
        private Long jdPrice;

        /**
         * 商家店内分类编码
         */
        @NotNull
        private Long shopCategoryId;

        /**
         * 门店商品可售状态，true为可售，false为不可售，默认为可售。
         */
        private Boolean isSale;

        public String getOutSkuId() {
            return outSkuId;
        }

        public void setOutSkuId(String outSkuId) {
            this.outSkuId = outSkuId;
        }

        public String getUpc() {
            return upc;
        }

        public void setUpc(String upc) {
            this.upc = upc;
        }

        public Long getJdPrice() {
            return jdPrice;
        }

        public void setJdPrice(Long jdPrice) {
            this.jdPrice = jdPrice;
        }

        public Long getShopCategoryId() {
            return shopCategoryId;
        }

        public void setShopCategoryId(Long shopCategoryId) {
            this.shopCategoryId = shopCategoryId;
        }

        public Boolean getIsSale() {
            return isSale;
        }

        public void setIsSale(Boolean isSale) {
            this.isSale = isSale;
        }
    }
}
