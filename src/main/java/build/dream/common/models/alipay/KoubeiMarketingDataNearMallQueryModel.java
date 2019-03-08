package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class KoubeiMarketingDataNearMallQueryModel extends AlipayBasicModel {
    @Length(max = 10)
    private String radius;

    @Length(max = 32)
    @JsonProperty(value = "user_id")
    private String userId;

    @Length(max = 20)
    @JsonProperty(value = "city_id")
    private String cityId;

    @Length(max = 20)
    @JsonProperty(value = "app_channel")
    private String appChannel;

    @NotNull
    private BigDecimal x;

    @NotNull
    private BigDecimal y;

    @JsonProperty(value = "page_no")
    private Integer pageNo;

    @JsonProperty(value = "page_size")
    private Integer pageSize;

    @Length(max = 20)
    @JsonProperty(value = "product_version")
    private String productVersion;

    @Length(max = 20)
    @JsonProperty(value = "product_id")
    private String productId;

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAppChannel() {
        return appChannel;
    }

    public void setAppChannel(String appChannel) {
        this.appChannel = appChannel;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
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

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public static class Builder {
        private final KoubeiMarketingDataNearMallQueryModel instance = new KoubeiMarketingDataNearMallQueryModel();

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

        public Builder radius(String radius) {
            instance.setRadius(radius);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder cityId(String cityId) {
            instance.setCityId(cityId);
            return this;
        }

        public Builder appChannel(String appChannel) {
            instance.setAppChannel(appChannel);
            return this;
        }

        public Builder x(BigDecimal x) {
            instance.setX(x);
            return this;
        }

        public Builder y(BigDecimal y) {
            instance.setY(y);
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

        public Builder productVersion(String productVersion) {
            instance.setProductVersion(productVersion);
            return this;
        }

        public Builder productId(String productId) {
            instance.setProductId(productId);
            return this;
        }

        public KoubeiMarketingDataNearMallQueryModel build() {
            KoubeiMarketingDataNearMallQueryModel koubeiMarketingDataNearMallQueryModel = new KoubeiMarketingDataNearMallQueryModel();
            koubeiMarketingDataNearMallQueryModel.setTenantId(instance.getTenantId());
            koubeiMarketingDataNearMallQueryModel.setBranchId(instance.getBranchId());
            koubeiMarketingDataNearMallQueryModel.setReturnUrl(instance.getReturnUrl());
            koubeiMarketingDataNearMallQueryModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiMarketingDataNearMallQueryModel.setAuthToken(instance.getAuthToken());
            koubeiMarketingDataNearMallQueryModel.setRadius(instance.getRadius());
            koubeiMarketingDataNearMallQueryModel.setUserId(instance.getUserId());
            koubeiMarketingDataNearMallQueryModel.setCityId(instance.getCityId());
            koubeiMarketingDataNearMallQueryModel.setAppChannel(instance.getAppChannel());
            koubeiMarketingDataNearMallQueryModel.setX(instance.getX());
            koubeiMarketingDataNearMallQueryModel.setY(instance.getY());
            koubeiMarketingDataNearMallQueryModel.setPageNo(instance.getPageNo());
            koubeiMarketingDataNearMallQueryModel.setPageSize(instance.getPageSize());
            koubeiMarketingDataNearMallQueryModel.setProductVersion(instance.getProductVersion());
            koubeiMarketingDataNearMallQueryModel.setProductId(instance.getProductId());
            return koubeiMarketingDataNearMallQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
