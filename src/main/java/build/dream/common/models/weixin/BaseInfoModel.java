package build.dream.common.models.weixin;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

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
