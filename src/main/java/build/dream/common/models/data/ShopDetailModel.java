package build.dream.common.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class ShopDetailModel extends DadaBasicModel {
    /**
     * 门店编码
     */
    @NotNull
    @JsonProperty(value = "origin_shop_id")
    private String originShopId;

    public String getOriginShopId() {
        return originShopId;
    }

    public void setOriginShopId(String originShopId) {
        this.originShopId = originShopId;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, ShopDetailModel> {
        public Builder originShopId(String originShopId) {
            instance.setOriginShopId(originShopId);
            return this;
        }

        @Override
        public ShopDetailModel build() {
            ShopDetailModel shopDetailModel = super.build();
            shopDetailModel.setOriginShopId(instance.getOriginShopId());
            return shopDetailModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
