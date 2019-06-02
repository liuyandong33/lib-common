package build.dream.common.models.beeleme;

import build.dream.common.utils.ValidateUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.NotNull;

public class ShopAnnouncementSetModel extends BeElemeBasicModel {
    @SerializedName(value = "baidu_shop_id", alternate = "baiduShopId")
    @JsonProperty(value = "baidu_shop_id")
    private String baiduShopId;

    @SerializedName(value = "shop_id", alternate = "shopId")
    @JsonProperty(value = "shop_id")
    private String shopId;

    private String descritption;

    @NotNull
    private String content;

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

    public String getDescritption() {
        return descritption;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        private final ShopAnnouncementSetModel instance = new ShopAnnouncementSetModel();

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

        public Builder descritption(String descritption) {
            instance.setDescritption(descritption);
            return this;
        }

        public Builder content(String content) {
            instance.setContent(content);
            return this;
        }

        public ShopAnnouncementSetModel build() {
            ShopAnnouncementSetModel shopAnnouncementSetModel = new ShopAnnouncementSetModel();
            shopAnnouncementSetModel.setSource(instance.getSource());
            shopAnnouncementSetModel.setEncrypt(instance.getEncrypt());
            shopAnnouncementSetModel.setFields(instance.getFields());
            shopAnnouncementSetModel.setBaiduShopId(instance.getBaiduShopId());
            shopAnnouncementSetModel.setShopId(instance.getShopId());
            shopAnnouncementSetModel.setDescritption(instance.getDescritption());
            shopAnnouncementSetModel.setContent(instance.getContent());
            return shopAnnouncementSetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}