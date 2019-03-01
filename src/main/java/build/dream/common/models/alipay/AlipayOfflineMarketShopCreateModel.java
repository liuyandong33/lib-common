package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;
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

    @SerializedName(value = "store_id", alternate = "storeId")
    @NotNull
    @Length(max = 32)
    private String storeId;

    @SerializedName(value = "category_id", alternate = "categoryId")
    @NotNull
    @Length(max = 32)
    private String categoryId;

    @SerializedName(value = "brand_name", alternate = "brandName")
    @Length(max = 512)
    private String brandName;

    @SerializedName(value = "brand_logo", alternate = "brandLogo")
    @Length(max = 512)
    private String brandLogo;

    @SerializedName(value = "main_shop_name", alternate = "mainShopName")
    @NotNull
    @Length(max = 20)
    private String mainShopName;

    @SerializedName(value = "branch_shop_name", alternate = "branchShopName")
    @Length(max = 20)
    private String branchShopName;

    @SerializedName(value = "province_code", alternate = "provinceCode")
    @NotNull
    @Length(max = 10)
    private String provinceCode;

    @SerializedName(value = "city_code", alternate = "cityCode")
    @NotNull
    @Length(max = 10)
    private String cityCode;

    @SerializedName(value = "district_code", alternate = "districtCode")
    @NotNull
    @Length(max = 10)
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

    @SerializedName(value = "contact_number", alternate = "contactNumber")
    @NotNull
    @Length(max = 512)
    private String contactNumber;

    @SerializedName(value = "notify_mobile", alternate = "notifyMobile")
    @Length(max = 512)
    private String notifyMobile;

    @SerializedName(value = "main_image", alternate = "mainImage")
    @Length(max = 512)
    private String mainImage;

    @SerializedName(value = "audit_images", alternate = "auditImages")
    @Length(max = 4000)
    private String auditImages;

    @SerializedName(value = "business_time", alternate = "businessTime")
    @Length(max = 256)
    private String businessTime;

    @InList(value = {"T", "F"})
    private String wifi;

    @InList(value = {"T", "F"})
    private String parking;

    @SerializedName(value = "value_added", alternate = "valueAdded")
    @Length(max = 256)
    private String valueAdded;

    @SerializedName(value = "avg_price", alternate = "avgPrice")
    @DecimalMin(value = "1")
    @DecimalMax(value = "99999")
    private BigDecimal avgPrice;

    @SerializedName(value = "isv_uid", alternate = "isvUid")
    @NotNull
    @Length(max = 16)
    private String isvUid;

    @Length(max = 512)
    private String licence;

    @SerializedName(value = "licence_code", alternate = "licenceCode")
    @Length(max = 255)
    private String licenceCode;

    @SerializedName(value = "licence_name", alternate = "licenceName")
    @Length(max = 255)
    private String licenceName;

    @SerializedName(value = "business_certificate", alternate = "businessCertificate")
    @Length(max = 512)
    private String businessCertificate;

    @SerializedName(value = "business_certificate_expires", alternate = "businessCertificateExpires")
    @Length(max = 64)
    private String businessCertificateExpires;

    @SerializedName(value = "auth_letter", alternate = "authLetter")
    @Length(max = 512)
    private String authLetter;

    @SerializedName(value = "is_operating_online", alternate = "isOperatingOnline")
    @InList(value = {"T", "F"})
    private String isOperatingOnline;

    @SerializedName(value = "online_url", alternate = "onlineUrl")
    @Length(max = 2000)
    private String onlineUrl;

    @SerializedName(value = "operate_notify_url", alternate = "operateNotifyUrl")
    @Length(max = 512)
    private String operateNotifyUrl;

    @SerializedName(value = "implement_id", alternate = "implementId")
    @Length(max = 256)
    private String implementId;

    @SerializedName(value = "no_smoking", alternate = "noSmoking")
    @InList(value = {"T", "F"})
    private String noSmoking;

    @InList(value = {"T", "F"})
    private String box;

    @SerializedName(value = "request_id", alternate = "requestId")
    @NotNull
    @Length(max = 64)
    private String requestId;

    @SerializedName(value = "other_authorization", alternate = "otherAuthorization")
    @Length(max = 500)
    private String otherAuthorization;

    @SerializedName(value = "licence_expires", alternate = "licenceExpires")
    @Length(max = 64)
    private String licenceExpires;

    @SerializedName(value = "op_role", alternate = "opRole")
    @Length(max = 16)
    private String opRole;

    @SerializedName(value = "biz_version", alternate = "bizVersion")
    @NotNull
    @Length(max = 10)
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
