package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingDataMallShopItemsQueryModel extends AlipayBasicModel {
    @Length(max = 32)
    @JsonProperty(value = "user_id")
    private String userId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "mall_id")
    private String mallId;

    @Length(max = 10)
    @JsonProperty(value = "collect_type")
    private String collectType;

    @JsonProperty(value = "page_no")
    private Integer pageNo;

    @JsonProperty(value = "page_size")
    private Integer pageSize;

    @JsonProperty(value = "max_items_num")
    private Integer maxItemsNum;

    @JsonProperty(value = "max_coupons_num")
    private Integer maxCouponsNum;

    @Length(max = 50)
    @JsonProperty(value = "product_id")
    private String productId;

    @Length(max = 50)
    @JsonProperty(value = "product_version")
    private String productVersion;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMallId() {
        return mallId;
    }

    public void setMallId(String mallId) {
        this.mallId = mallId;
    }

    public String getCollectType() {
        return collectType;
    }

    public void setCollectType(String collectType) {
        this.collectType = collectType;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getMaxItemsNum() {
        return maxItemsNum;
    }

    public void setMaxItemsNum(Integer maxItemsNum) {
        this.maxItemsNum = maxItemsNum;
    }

    public Integer getMaxCouponsNum() {
        return maxCouponsNum;
    }

    public void setMaxCouponsNum(Integer maxCouponsNum) {
        this.maxCouponsNum = maxCouponsNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public static class Builder {
        private final KoubeiMarketingDataMallShopItemsQueryModel instance = new KoubeiMarketingDataMallShopItemsQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder mallId(String mallId) {
            instance.setMallId(mallId);
            return this;
        }

        public Builder collectType(String collectType) {
            instance.setCollectType(collectType);
            return this;
        }

        public Builder pageNo(Integer pageNo) {
            instance.setPageNo(pageNo);
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        public Builder maxItemsNum(Integer maxItemsNum) {
            instance.setMaxItemsNum(maxItemsNum);
            return this;
        }

        public Builder maxCouponsNum(Integer maxCouponsNum) {
            instance.setMaxCouponsNum(maxCouponsNum);
            return this;
        }

        public Builder productId(String productId) {
            instance.setProductId(productId);
            return this;
        }

        public Builder productVersion(String productVersion) {
            instance.setProductVersion(productVersion);
            return this;
        }

        public KoubeiMarketingDataMallShopItemsQueryModel build() {
            KoubeiMarketingDataMallShopItemsQueryModel koubeiMarketingDataMallShopItemsQueryModel = new KoubeiMarketingDataMallShopItemsQueryModel();
            koubeiMarketingDataMallShopItemsQueryModel.setTenantId(instance.getTenantId());
            koubeiMarketingDataMallShopItemsQueryModel.setBranchId(instance.getBranchId());
            koubeiMarketingDataMallShopItemsQueryModel.setReturnUrl(instance.getReturnUrl());
            koubeiMarketingDataMallShopItemsQueryModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiMarketingDataMallShopItemsQueryModel.setAuthToken(instance.getAuthToken());
            koubeiMarketingDataMallShopItemsQueryModel.setUserId(instance.getUserId());
            koubeiMarketingDataMallShopItemsQueryModel.setMallId(instance.getMallId());
            koubeiMarketingDataMallShopItemsQueryModel.setCollectType(instance.getCollectType());
            koubeiMarketingDataMallShopItemsQueryModel.setPageNo(instance.getPageNo());
            koubeiMarketingDataMallShopItemsQueryModel.setPageSize(instance.getPageSize());
            koubeiMarketingDataMallShopItemsQueryModel.setMaxItemsNum(instance.getMaxItemsNum());
            koubeiMarketingDataMallShopItemsQueryModel.setMaxCouponsNum(instance.getMaxCouponsNum());
            koubeiMarketingDataMallShopItemsQueryModel.setProductId(instance.getProductId());
            koubeiMarketingDataMallShopItemsQueryModel.setProductVersion(instance.getProductVersion());
            return koubeiMarketingDataMallShopItemsQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
