package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOfflineMarketShopQueryDetailModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "shop_id")
    private String shopId;

    @Length(max = 32)
    @JsonProperty(value = "op_role")
    private String opRole;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getOpRole() {
        return opRole;
    }

    public void setOpRole(String opRole) {
        this.opRole = opRole;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOfflineMarketShopQueryDetailModel instance = new AlipayOfflineMarketShopQueryDetailModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder shopId(String shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public Builder opRole(String opRole) {
            instance.setOpRole(opRole);
            return this;
        }

        public AlipayOfflineMarketShopQueryDetailModel build() {
            AlipayOfflineMarketShopQueryDetailModel alipayOfflineMarketShopQueryDetailModel = new AlipayOfflineMarketShopQueryDetailModel();
            build(alipayOfflineMarketShopQueryDetailModel);
            alipayOfflineMarketShopQueryDetailModel.setShopId(instance.getShopId());
            alipayOfflineMarketShopQueryDetailModel.setOpRole(instance.getOpRole());
            return alipayOfflineMarketShopQueryDetailModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
