package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AlipayOfflineMarketShopCreateModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @JsonIgnore
    private String notifyUrl;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "store_id")
    private String storeId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "category_id")
    private String categoryId;

    @Length(max = 512)
    @JsonProperty(value = "brand_name")
    private String brandName;

    @Length(max = 512)
    @JsonProperty(value = "brand_logo")
    private String brandLogo;

    @NotNull
    @Length(max = 20)
    @JsonProperty(value = "main_shop_name")
    private String mainShopName;

    @Length(max = 20)
    @JsonProperty(value = "branch_shop_name")
    private String branchShopName;

    @NotNull
    @Length(max = 10)
    @JsonProperty(value = "province_code")
    private String provinceCode;

    @NotNull
    @Length(max = 10)
    @JsonProperty(value = "city_code")
    private String cityCode;

    @NotNull
    @Length(max = 10)
    @JsonProperty(value = "district_code")
    private String districtCode;

    @NotNull
    @Length(max = 50)
    private String address;

    @NotNull
    @Length(max = 15)
    private String longitude;

    @NotNull
    @Length(max = 15)
    private String latitude;

    @NotNull
    @Length(max = 512)
    @JsonProperty(value = "contact_number")
    private String contactNumber;

    @Length(max = 512)
    @JsonProperty(value = "notify_mobile")
    private String notifyMobile;

    @Length(max = 512)
    @JsonProperty(value = "main_image")
    private String mainImage;

    @Length(max = 4000)
    @JsonProperty(value = "audit_images")
    private String auditImages;

    @Length(max = 256)
    @JsonProperty(value = "business_time")
    private String businessTime;

    @InList(value = {"T", "F"})
    private String wifi;

    @InList(value = {"T", "F"})
    private String parking;

    @Length(max = 256)
    @JsonProperty(value = "value_added")
    private String valueAdded;

    @DecimalMin(value = "1")
    @DecimalMax(value = "99999")
    @JsonProperty(value = "avg_price")
    private BigDecimal avgPrice;

    @NotNull
    @Length(max = 16)
    @JsonProperty(value = "isv_uid")
    private String isvUid;

    @Length(max = 512)
    private String licence;

    @Length(max = 255)
    @JsonProperty(value = "licence_code")
    private String licenceCode;

    @Length(max = 255)
    @JsonProperty(value = "licence_name")
    private String licenceName;

    @Length(max = 512)
    @JsonProperty(value = "business_certificate")
    private String businessCertificate;

    @Length(max = 64)
    @JsonProperty(value = "business_certificate_expires")
    private String businessCertificateExpires;

    @Length(max = 512)
    @JsonProperty(value = "auth_letter")
    private String authLetter;

    @InList(value = {"T", "F"})
    @JsonProperty(value = "is_operating_online")
    private String isOperatingOnline;

    @Length(max = 2000)
    @JsonProperty(value = "online_url")
    private String onlineUrl;

    @Length(max = 512)
    @JsonProperty(value = "operate_notify_url")
    private String operateNotifyUrl;

    @Length(max = 256)
    @JsonProperty(value = "implement_id")
    private String implementId;

    @InList(value = {"T", "F"})
    @JsonProperty(value = "no_smoking")
    private String noSmoking;

    @InList(value = {"T", "F"})
    private String box;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "request_id")
    private String requestId;

    @Length(max = 500)
    @JsonProperty(value = "other_authorization")
    private String otherAuthorization;

    @Length(max = 64)
    @JsonProperty(value = "licence_expires")
    private String licenceExpires;

    @Length(max = 16)
    @JsonProperty(value = "op_role")
    private String opRole;

    @NotNull
    @Length(max = 10)
    @JsonProperty(value = "biz_version")
    private String bizVersion;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getMainShopName() {
        return mainShopName;
    }

    public void setMainShopName(String mainShopName) {
        this.mainShopName = mainShopName;
    }

    public String getBranchShopName() {
        return branchShopName;
    }

    public void setBranchShopName(String branchShopName) {
        this.branchShopName = branchShopName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNotifyMobile() {
        return notifyMobile;
    }

    public void setNotifyMobile(String notifyMobile) {
        this.notifyMobile = notifyMobile;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getAuditImages() {
        return auditImages;
    }

    public void setAuditImages(String auditImages) {
        this.auditImages = auditImages;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getValueAdded() {
        return valueAdded;
    }

    public void setValueAdded(String valueAdded) {
        this.valueAdded = valueAdded;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getIsvUid() {
        return isvUid;
    }

    public void setIsvUid(String isvUid) {
        this.isvUid = isvUid;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getLicenceCode() {
        return licenceCode;
    }

    public void setLicenceCode(String licenceCode) {
        this.licenceCode = licenceCode;
    }

    public String getLicenceName() {
        return licenceName;
    }

    public void setLicenceName(String licenceName) {
        this.licenceName = licenceName;
    }

    public String getBusinessCertificate() {
        return businessCertificate;
    }

    public void setBusinessCertificate(String businessCertificate) {
        this.businessCertificate = businessCertificate;
    }

    public String getBusinessCertificateExpires() {
        return businessCertificateExpires;
    }

    public void setBusinessCertificateExpires(String businessCertificateExpires) {
        this.businessCertificateExpires = businessCertificateExpires;
    }

    public String getAuthLetter() {
        return authLetter;
    }

    public void setAuthLetter(String authLetter) {
        this.authLetter = authLetter;
    }

    public String getIsOperatingOnline() {
        return isOperatingOnline;
    }

    public void setIsOperatingOnline(String isOperatingOnline) {
        this.isOperatingOnline = isOperatingOnline;
    }

    public String getOnlineUrl() {
        return onlineUrl;
    }

    public void setOnlineUrl(String onlineUrl) {
        this.onlineUrl = onlineUrl;
    }

    public String getOperateNotifyUrl() {
        return operateNotifyUrl;
    }

    public void setOperateNotifyUrl(String operateNotifyUrl) {
        this.operateNotifyUrl = operateNotifyUrl;
    }

    public String getImplementId() {
        return implementId;
    }

    public void setImplementId(String implementId) {
        this.implementId = implementId;
    }

    public String getNoSmoking() {
        return noSmoking;
    }

    public void setNoSmoking(String noSmoking) {
        this.noSmoking = noSmoking;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getOtherAuthorization() {
        return otherAuthorization;
    }

    public void setOtherAuthorization(String otherAuthorization) {
        this.otherAuthorization = otherAuthorization;
    }

    public String getLicenceExpires() {
        return licenceExpires;
    }

    public void setLicenceExpires(String licenceExpires) {
        this.licenceExpires = licenceExpires;
    }

    public String getOpRole() {
        return opRole;
    }

    public void setOpRole(String opRole) {
        this.opRole = opRole;
    }


    public String getBizVersion() {
        return bizVersion;
    }

    public void setBizVersion(String bizVersion) {
        this.bizVersion = bizVersion;
    }
}
