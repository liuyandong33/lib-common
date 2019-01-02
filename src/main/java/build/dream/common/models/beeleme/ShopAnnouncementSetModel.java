package build.dream.common.models.beeleme;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ValidateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.NotNull;

public class ShopAnnouncementSetModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String source;

    @SerializedName(value = "baidu_shop_id", alternate = "baiduShopId")
    @JsonProperty(value = "baidu_shop_id")
    private String baiduShopId;

    @SerializedName(value = "shop_id", alternate = "shopId")
    @JsonProperty(value = "shop_id")
    private String shopId;

    private String descritption;

    @NotNull
    private String content;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

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
}
