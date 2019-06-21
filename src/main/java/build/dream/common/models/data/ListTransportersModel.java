package build.dream.common.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class ListTransportersModel extends DadaBasicModel {
    @NotNull
    @JsonProperty(value = "shop_no")
    private String shopNo;

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, ListTransportersModel> {
        public Builder shopNo(String shopNo) {
            instance.setShopNo(shopNo);
            return this;
        }

        @Override
        public ListTransportersModel build() {
            ListTransportersModel listTransportersModel = super.build();
            listTransportersModel.setShopNo(instance.getShopNo());
            return listTransportersModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
