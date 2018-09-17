package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class Branch extends BasicDomain {
    /**
     * 商户id
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店编码
     */
    private String code;
    /**
     * 门店名称
     */
    private String name;
    /**
     * 门店类型，1-总部，2-直营店，3加盟店
     */
    private Integer type;
    /**
     * 门店状态，1-正常
     */
    private Integer status;
    /**
     * 省编码
     */
    private String provinceCode;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 市编码
     */
    private String cityCode;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 区编码
     */
    private String districtCode;
    /**
     * 区名称
     */
    private String districtName;
    /**
     * 门店详细地址
     */
    private String address;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 联系人
     */
    private String linkman;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 饿了么账号类型，1-连锁账号，2-独立账号
     */
    private Integer elemeAccountType = Constants.ELEME_ACCOUNT_TYPE_CHAIN_ACCOUNT;
    /**
     * 饿了么门店id
     */
    private BigInteger shopId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 微餐厅状态，1-正常，2-禁用
     */
    private Integer smartRestaurantStatus = Constants.SMART_RESTAURANT_STATUS_DISABLED;
    /**
     * 美团门店绑定的授权token
     */
    private String appAuthToken = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 美团门店id
     */
    private String poiId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 美团门店名称
     */
    private String poiName = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 会员分组ID
     */
    private BigInteger vipGroupId = Constants.BIGINT_DEFAULT_VALUE;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getElemeAccountType() {
        return elemeAccountType;
    }

    public void setElemeAccountType(Integer elemeAccountType) {
        this.elemeAccountType = elemeAccountType;
    }

    public BigInteger getShopId() {
        return shopId;
    }

    public void setShopId(BigInteger shopId) {
        this.shopId = shopId;
    }

    public Integer getSmartRestaurantStatus() {
        return smartRestaurantStatus;
    }

    public void setSmartRestaurantStatus(Integer smartRestaurantStatus) {
        this.smartRestaurantStatus = smartRestaurantStatus;
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    public BigInteger getVipGroupId() {
        return vipGroupId;
    }

    public void setVipGroupId(BigInteger vipGroupId) {
        this.vipGroupId = vipGroupId;
    }

    public static class Builder {
        private final Branch instance = new Branch();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        public Builder provinceCode(String provinceCode) {
            instance.setProvinceCode(provinceCode);
            return this;
        }

        public Builder provinceName(String provinceName) {
            instance.setProvinceName(provinceName);
            return this;
        }

        public Builder cityCode(String cityCode) {
            instance.setCityCode(cityCode);
            return this;
        }

        public Builder cityName(String cityName) {
            instance.setCityName(cityName);
            return this;
        }

        public Builder districtCode(String districtCode) {
            instance.setDistrictCode(districtCode);
            return this;
        }

        public Builder districtName(String districtName) {
            instance.setDistrictName(districtName);
            return this;
        }

        public Builder address(String address) {
            instance.setAddress(address);
            return this;
        }

        public Builder longitude(String longitude) {
            instance.setLongitude(longitude);
            return this;
        }

        public Builder latitude(String latitude) {
            instance.setLatitude(latitude);
            return this;
        }

        public Builder linkman(String linkman) {
            instance.setLinkman(linkman);
            return this;
        }

        public Builder contactPhone(String contactPhone) {
            instance.setContactPhone(contactPhone);
            return this;
        }

        public Builder elemeAccountType(Integer elemeAccountType) {
            instance.setElemeAccountType(elemeAccountType);
            return this;
        }

        public Builder shopId(BigInteger shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public Builder smartRestaurantStatus(Integer smartRestaurantStatus) {
            instance.setSmartRestaurantStatus(smartRestaurantStatus);
            return this;
        }

        public Builder appAuthToken(String appAuthToken) {
            instance.setAppAuthToken(appAuthToken);
            return this;
        }

        public Builder poiId(String poiId) {
            instance.setPoiId(poiId);
            return this;
        }

        public Builder poiName(String poiName) {
            instance.setPoiName(poiName);
            return this;
        }

        public Builder vipGroupId(BigInteger vipGroupId) {
            instance.setVipGroupId(vipGroupId);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public Branch build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String STATUS = "status";
        public static final String PROVINCE_CODE = "province_code";
        public static final String PROVINCE_NAME = "province_name";
        public static final String CITY_CODE = "city_code";
        public static final String CITY_NAME = "city_name";
        public static final String DISTRICT_CODE = "district_code";
        public static final String DISTRICT_NAME = "district_name";
        public static final String ADDRESS = "address";
        public static final String LONGITUDE = "longitude";
        public static final String LATITUDE = "latitude";
        public static final String LINKMAN = "linkman";
        public static final String CONTACT_PHONE = "contact_phone";
        public static final String ELEME_ACCOUNT_TYPE = "eleme_account_type";
        public static final String SHOP_ID = "shop_id";
        public static final String SMART_RESTAURANT_STATUS = "smart_restaurant_status";
        public static final String APP_AUTH_TOKEN = "app_auth_token";
        public static final String POI_ID = "poi_id";
        public static final String POI_NAME = "poi_name";
        public static final String VIP_GROUP_ID = "vip_group_id";
    }
}
