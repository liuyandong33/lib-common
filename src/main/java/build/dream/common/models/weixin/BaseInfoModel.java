package build.dream.common.models.weixin;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BaseInfoModel extends BasicModel {
    @NotNull
    @Length(max = 128)
    @SerializedName(value = "logo_url", alternate = "logoUrl")
    private String logoUrl;

    @NotNull
    @InList(value = {"CODE_TYPE_TEXT", "CODE_TYPE_BARCODE", "CODE_TYPE_QRCODE", "CODE_TYPE_ONLY_QRCODE", "CODE_TYPE_ONLY_BARCODE", "CODE_TYPE_NONE"})
    @SerializedName(value = "code_type", alternate = "codeType")
    private String codeType;

    @NotNull
    @Length(max = 36)
    @SerializedName(value = "brand_name", alternate = "brandName")
    private String brandName;

    @NotNull
    @Length(max = 27)
    private String title;

    @NotNull
    @InList(value = {"Color010", "Color020", "Color030", "Color040", "Color050", "Color060", "Color070", "Color080", "Color081", "Color082", "Color090", "Color100", "Color101", "Color102"})
    private String color;

    @NotNull
    @Length(max = 48)
    private String notice;

    @NotNull
    @Length(max = 3072)
    private String description;

    @NotNull
    private Sku sku;

    @NotNull
    @SerializedName(value = "date_info", alternate = "dateInfo")
    private DateInfo dateInfo;

    @SerializedName(value = "use_custom_code", alternate = "useCustomCode")
    private Boolean useCustomCode;

    @InList(value = "GET_CUSTOM_COD E_MODE_DEPOSIT")
    @SerializedName(value = "get_custom_code_mode", alternate = "getCustomCodeMode")
    private String getCustomCodeMode;

    @SerializedName(value = "bind_openid", alternate = "bindOpenid")
    private Boolean bindOpenid;

    @Length(max = 24)
    @SerializedName(value = "service_phone", alternate = "servicePhone")
    private String servicePhone;

    @SerializedName(value = "location_id_list", alternate = "locationIdList")
    private List<String> locationIdList;

    @SerializedName(value = "use_all_locations", alternate = "useAllLocations")
    private Boolean useAllLocations;

    @Length(max = 18)
    @SerializedName(value = "center_title", alternate = "centerTitle")
    private String centerTitle;

    @Length(max = 24)
    @SerializedName(value = "center_sub_title", alternate = "centerSubTitle")
    private String centerSubTitle;

    @Length(max = 128)
    @SerializedName(value = "center_url", alternate = "centerUrl")
    private String centerUrl;

    @Length(max = 128)
    @SerializedName(value = "center_app_brand_user_name", alternate = "centerAppBrandUserName")
    private String centerAppBrandUserName;

    @Length(max = 128)
    @SerializedName(value = "center_app_brand_pass", alternate = "centerAppBrandPass")
    private String centerAppBrandPass;

    @Length(max = 15)
    @SerializedName(value = "custom_url_name", alternate = "customUrlName")
    private String customUrlName;

    @Length(max = 128)
    @SerializedName(value = "custom_url", alternate = "customUrl")
    private String customUrl;

    @Length(max = 18)
    @SerializedName(value = "custom_url_sub_title", alternate = "customUrlSubTitle")
    private String customUrlSubTitle;

    @Length(max = 128)
    @SerializedName(value = "custom_app_brand_user_name", alternate = "customAppBrandUserName")
    private String customAppBrandUserName;

    @Length(max = 128)
    @SerializedName(value = "custom_app_brand_pass", alternate = "customAppBrandPass")
    private String customAppBrandPass;

    @Length(max = 15)
    @SerializedName(value = "promotion_url_name", alternate = "promotionUrlName")
    private String promotionUrlName;

    @Length(max = 128)
    @SerializedName(value = "promotion_url", alternate = "promotionUrl")
    private String promotionUrl;

    @Length(max = 18)
    @SerializedName(value = "promotion_url_sub_title", alternate = "promotionUrlSubTitle")
    private String promotionUrlSubTitle;

    @Length(max = 128)
    @SerializedName(value = "promotion_app_brand_user_name", alternate = "promotionAppBrandUserName")
    private String promotionAppBrandUserName;

    @Length(max = 128)
    @SerializedName(value = "promotion_app_brand_pass", alternate = "promotionAppBrandPass")
    private String promotionAppBrandPass;

    @SerializedName(value = "get_limit", alternate = "getLimit")
    private Integer getLimit;

    @SerializedName(value = "use_limit", alternate = "useLimit")
    private Integer useLimit;

    @SerializedName(value = "can_share", alternate = "canShare")
    private Boolean canShare;

    @SerializedName(value = "can_give_friend", alternate = "canGiveFriend")
    private Boolean canGiveFriend;


    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public DateInfo getDateInfo() {
        return dateInfo;
    }

    public void setDateInfo(DateInfo dateInfo) {
        this.dateInfo = dateInfo;
    }

    public Boolean getUseCustomCode() {
        return useCustomCode;
    }

    public void setUseCustomCode(Boolean useCustomCode) {
        this.useCustomCode = useCustomCode;
    }

    public String getGetCustomCodeMode() {
        return getCustomCodeMode;
    }

    public void setGetCustomCodeMode(String getCustomCodeMode) {
        this.getCustomCodeMode = getCustomCodeMode;
    }

    public Boolean getBindOpenid() {
        return bindOpenid;
    }

    public void setBindOpenid(Boolean bindOpenid) {
        this.bindOpenid = bindOpenid;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public List<String> getLocationIdList() {
        return locationIdList;
    }

    public void setLocationIdList(List<String> locationIdList) {
        this.locationIdList = locationIdList;
    }

    public Boolean getUseAllLocations() {
        return useAllLocations;
    }

    public void setUseAllLocations(Boolean useAllLocations) {
        this.useAllLocations = useAllLocations;
    }

    public String getCenterTitle() {
        return centerTitle;
    }

    public void setCenterTitle(String centerTitle) {
        this.centerTitle = centerTitle;
    }

    public String getCenterSubTitle() {
        return centerSubTitle;
    }

    public void setCenterSubTitle(String centerSubTitle) {
        this.centerSubTitle = centerSubTitle;
    }

    public String getCenterUrl() {
        return centerUrl;
    }

    public void setCenterUrl(String centerUrl) {
        this.centerUrl = centerUrl;
    }

    public String getCenterAppBrandUserName() {
        return centerAppBrandUserName;
    }

    public void setCenterAppBrandUserName(String centerAppBrandUserName) {
        this.centerAppBrandUserName = centerAppBrandUserName;
    }

    public String getCenterAppBrandPass() {
        return centerAppBrandPass;
    }

    public void setCenterAppBrandPass(String centerAppBrandPass) {
        this.centerAppBrandPass = centerAppBrandPass;
    }

    public String getCustomUrlName() {
        return customUrlName;
    }

    public void setCustomUrlName(String customUrlName) {
        this.customUrlName = customUrlName;
    }

    public String getCustomUrl() {
        return customUrl;
    }

    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    public String getCustomUrlSubTitle() {
        return customUrlSubTitle;
    }

    public void setCustomUrlSubTitle(String customUrlSubTitle) {
        this.customUrlSubTitle = customUrlSubTitle;
    }

    public String getCustomAppBrandUserName() {
        return customAppBrandUserName;
    }

    public void setCustomAppBrandUserName(String customAppBrandUserName) {
        this.customAppBrandUserName = customAppBrandUserName;
    }

    public String getCustomAppBrandPass() {
        return customAppBrandPass;
    }

    public void setCustomAppBrandPass(String customAppBrandPass) {
        this.customAppBrandPass = customAppBrandPass;
    }

    public String getPromotionUrlName() {
        return promotionUrlName;
    }

    public void setPromotionUrlName(String promotionUrlName) {
        this.promotionUrlName = promotionUrlName;
    }

    public String getPromotionUrl() {
        return promotionUrl;
    }

    public void setPromotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
    }

    public String getPromotionUrlSubTitle() {
        return promotionUrlSubTitle;
    }

    public void setPromotionUrlSubTitle(String promotionUrlSubTitle) {
        this.promotionUrlSubTitle = promotionUrlSubTitle;
    }

    public String getPromotionAppBrandUserName() {
        return promotionAppBrandUserName;
    }

    public void setPromotionAppBrandUserName(String promotionAppBrandUserName) {
        this.promotionAppBrandUserName = promotionAppBrandUserName;
    }

    public String getPromotionAppBrandPass() {
        return promotionAppBrandPass;
    }

    public void setPromotionAppBrandPass(String promotionAppBrandPass) {
        this.promotionAppBrandPass = promotionAppBrandPass;
    }

    public Integer getGetLimit() {
        return getLimit;
    }

    public void setGetLimit(Integer getLimit) {
        this.getLimit = getLimit;
    }

    public Integer getUseLimit() {
        return useLimit;
    }

    public void setUseLimit(Integer useLimit) {
        this.useLimit = useLimit;
    }

    public Boolean getCanShare() {
        return canShare;
    }

    public void setCanShare(Boolean canShare) {
        this.canShare = canShare;
    }

    public Boolean getCanGiveFriend() {
        return canGiveFriend;
    }

    public void setCanGiveFriend(Boolean canGiveFriend) {
        this.canGiveFriend = canGiveFriend;
    }

    public static class Sku extends BasicModel {
        @NotNull
        @Length(min = 1, max = 100000000)
        private Integer quantity;

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }

    public static class DateInfo extends BasicModel {
        @InList(value = {"DATE_TYPE_FIX_TIME_RANGE", "DATE_TYPE_FIX_TERM"})
        private String type;

        @SerializedName(value = "begin_timestamp", alternate = "beginTimestamp")
        private Long beginTimestamp;

        @SerializedName(value = "end_timestamp", alternate = "endTimestamp")
        private Long endTimestamp;

        @SerializedName(value = "fixed_term", alternate = "fixedTerm")
        private Integer fixedTerm;

        @SerializedName(value = "fixed_begin_term", alternate = "fixedBeginTerm")
        private Long fixedBeginTerm;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Long getBeginTimestamp() {
            return beginTimestamp;
        }

        public void setBeginTimestamp(Long beginTimestamp) {
            this.beginTimestamp = beginTimestamp;
        }

        public Long getEndTimestamp() {
            return endTimestamp;
        }

        public void setEndTimestamp(Long endTimestamp) {
            this.endTimestamp = endTimestamp;
        }

        public Integer getFixedTerm() {
            return fixedTerm;
        }

        public void setFixedTerm(Integer fixedTerm) {
            this.fixedTerm = fixedTerm;
        }

        public Long getFixedBeginTerm() {
            return fixedBeginTerm;
        }

        public void setFixedBeginTerm(Long fixedBeginTerm) {
            this.fixedBeginTerm = fixedBeginTerm;
        }
    }
}
