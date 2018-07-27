package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOfflineMarketShopCreateModel extends BasicModel {
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
}
