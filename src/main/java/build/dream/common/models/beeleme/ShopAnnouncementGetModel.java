package build.dream.common.models.beeleme;

import build.dream.common.utils.ValidateUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

public class ShopAnnouncementGetModel extends BeElemeBasicModel {
    @SerializedName(value = "baidu_shop_id", alternate = "baiduShopId")
    @JsonProperty(value = "baidu_shop_id")
    private String baiduShopId;

    @SerializedName(value = "shop_id", alternate = "shopId")
    @JsonProperty(value = "shop_id")
    private String shopId;

    public String getBaiduShopId() {
        return baiduShopId;
    }

    public void setBaiduShopId(String baiduShopId) {
        this.baiduShopId = baiduShopId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(baiduShopId) || StringUtils.isNotBlank(shopId));
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(baiduShopId) || StringUtils.isNotBlank(shopId), "参数 baiduShopId 和 shopId 和不能同时为空！");
    }

    public static class Builder {
        private ShopAnnouncementGetModel instance = new ShopAnnouncementGetModel();

        public Builder source(String source) {
            instance.setSource(source);
            return this;
        }

        public Builder encrypt(String encrypt) {
            instance.setEncrypt(encrypt);
            return this;
        }

        public Builder fields(String fields) {
            instance.setFields(fields);
            return this;
        }

        public Builder baiduShopId(String baiduShopId) {
            instance.setBaiduShopId(baiduShopId);
            return this;
        }

        public Builder shopId(String shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public ShopAnnouncementGetModel build() {
            ShopAnnouncementGetModel shopAnnouncementGetModel = new ShopAnnouncementGetModel();
            shopAnnouncementGetModel.setSource(instance.getSource());
            shopAnnouncementGetModel.setEncrypt(instance.getEncrypt());
            shopAnnouncementGetModel.setFields(instance.getFields());
            shopAnnouncementGetModel.setBaiduShopId(instance.getBaiduShopId());
            shopAnnouncementGetModel.setShopId(instance.getShopId());
            return shopAnnouncementGetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}