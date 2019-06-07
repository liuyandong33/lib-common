package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class KoubeiMarketingCampaignUserAssetQueryModel extends AlipayBasicModel {
    @NotNull
    @InList(value = {"USER_ALL_ASSET", "USER_MERCHANT_ASSET", "USER_SHOP_ASSET", "USER_SHOP_ASSET"})
    private String scope;

    @Length(max = 28)
    @JsonProperty(value = "shop_id")
    private String shopId;

    @NotNull
    @Min(value = 1)
    @Max(value = 99999)
    @JsonProperty(value = "page_num")
    private Integer pageNum;

    @NotNull
    @Min(value = 1)
    @Max(value = 50)
    @JsonProperty(value = "page_size")
    private Integer pageSize;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, KoubeiMarketingCampaignUserAssetQueryModel> {
        public Builder scope(String scope) {
            instance.setScope(scope);
            return this;
        }

        public Builder shopId(String shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public Builder pageNum(Integer pageNum) {
            instance.setPageNum(pageNum);
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        @Override
        public KoubeiMarketingCampaignUserAssetQueryModel build() {
            KoubeiMarketingCampaignUserAssetQueryModel koubeiMarketingCampaignUserAssetQueryModel = super.build();
            koubeiMarketingCampaignUserAssetQueryModel.setScope(instance.getScope());
            koubeiMarketingCampaignUserAssetQueryModel.setShopId(instance.getShopId());
            koubeiMarketingCampaignUserAssetQueryModel.setPageNum(instance.getPageNum());
            koubeiMarketingCampaignUserAssetQueryModel.setPageSize(instance.getPageSize());
            return koubeiMarketingCampaignUserAssetQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
