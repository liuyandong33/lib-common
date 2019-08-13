package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.annotations.Transient;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;
import build.dream.common.utils.JacksonUtils;

import java.math.BigInteger;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

@ShardingColumn(fieldName = Branch.FieldName.TENANT_ID, columnName = Branch.ColumnName.TENANT_ID)
public class Branch extends BasicDomain {
    public static final String TABLE_NAME = "branch";
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
     * 状态，1-启用，2-停用
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
    /**
     * 营业时间
     */
    private String businessTimes;
    /**
     * 是否正在营业
     */
    @Transient
    private boolean opened;

    /**
     * 达达门店ID
     */
    private String dadaOriginShopId = Constants.VARCHAR_DEFAULT_VALUE;

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

    public String getBusinessTimes() {
        return businessTimes;
    }

    public void setBusinessTimes(String businessTimes) {
        List<BusinessTime> businessTimeList = JacksonUtils.readValueAsList(businessTimes, BusinessTime.class);
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int prime = 0;
        if (dayOfWeek == 1) {
            prime = 17;
        } else if (dayOfWeek == 2) {
            prime = 2;
        } else if (dayOfWeek == 3) {
            prime = 3;
        } else if (dayOfWeek == 4) {
            prime = 5;
        } else if (dayOfWeek == 5) {
            prime = 7;
        } else if (dayOfWeek == 6) {
            prime = 11;
        } else if (dayOfWeek == 7) {
            prime = 13;
        }
        Time now = new Time(System.currentTimeMillis());
        for (BusinessTime businessTime : businessTimeList) {
            if (businessTime.getStartTime().before(now) && businessTime.getEndTime().after(now) && businessTime.getWeekSign() % prime == 0) {
                this.opened = true;
                break;
            }
        }
        this.businessTimes = businessTimes;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public String getDadaOriginShopId() {
        return dadaOriginShopId;
    }

    public void setDadaOriginShopId(String dadaOriginShopId) {
        this.dadaOriginShopId = dadaOriginShopId;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Branch> {
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

        public Builder businessTimes(String businessTimes) {
            instance.setBusinessTimes(businessTimes);
            return this;
        }

        public Builder opened(boolean opened) {
            instance.setOpened(opened);
            return this;
        }

        public Builder dadaOriginShopId(String dadaOriginShopId) {
            instance.setDadaOriginShopId(dadaOriginShopId);
            return this;
        }

        @Override
        public Branch build() {
            Branch branch = super.build();
            branch.setTenantId(instance.getTenantId());
            branch.setTenantCode(instance.getTenantCode());
            branch.setCode(instance.getCode());
            branch.setName(instance.getName());
            branch.setType(instance.getType());
            branch.setStatus(instance.getStatus());
            branch.setProvinceCode(instance.getProvinceCode());
            branch.setProvinceName(instance.getProvinceName());
            branch.setCityCode(instance.getCityCode());
            branch.setCityName(instance.getCityName());
            branch.setDistrictCode(instance.getDistrictCode());
            branch.setDistrictName(instance.getDistrictName());
            branch.setAddress(instance.getAddress());
            branch.setLongitude(instance.getLongitude());
            branch.setLatitude(instance.getLatitude());
            branch.setLinkman(instance.getLinkman());
            branch.setContactPhone(instance.getContactPhone());
            branch.setElemeAccountType(instance.getElemeAccountType());
            branch.setShopId(instance.getShopId());
            branch.setSmartRestaurantStatus(instance.getSmartRestaurantStatus());
            branch.setAppAuthToken(instance.getAppAuthToken());
            branch.setPoiId(instance.getPoiId());
            branch.setPoiName(instance.getPoiName());
            branch.setVipGroupId(instance.getVipGroupId());
            branch.setBusinessTimes(instance.getBusinessTimes());
            branch.setOpened(instance.isOpened());
            branch.setDadaOriginShopId(instance.getDadaOriginShopId());
            return branch;
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
        public static final String BUSINESS_TIMES = "business_times";
        public static final String DADA_ORIGIN_SHOP_ID = "dada_origin_shop_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String STATUS = "status";
        public static final String PROVINCE_CODE = "provinceCode";
        public static final String PROVINCE_NAME = "provinceName";
        public static final String CITY_CODE = "cityCode";
        public static final String CITY_NAME = "cityName";
        public static final String DISTRICT_CODE = "districtCode";
        public static final String DISTRICT_NAME = "districtName";
        public static final String ADDRESS = "address";
        public static final String LONGITUDE = "longitude";
        public static final String LATITUDE = "latitude";
        public static final String LINKMAN = "linkman";
        public static final String CONTACT_PHONE = "contactPhone";
        public static final String ELEME_ACCOUNT_TYPE = "elemeAccountType";
        public static final String SHOP_ID = "shopId";
        public static final String SMART_RESTAURANT_STATUS = "smartRestaurantStatus";
        public static final String APP_AUTH_TOKEN = "appAuthToken";
        public static final String POI_ID = "poiId";
        public static final String POI_NAME = "poiName";
        public static final String VIP_GROUP_ID = "vipGroupId";
        public static final String BUSINESS_TIMES = "businessTimes";
        public static final String OPENED = "opened";
        public static final String DADA_ORIGIN_SHOP_ID = "dadaOriginShopId";
    }
}
