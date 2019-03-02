package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayMarketingCardTemplateCreateModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "request_id")
    private String requestId;

    @NotNull
    @InList(value = {"OUT_MEMBER_CARD"})
    @JsonProperty(value = "card_type")
    private String cardType;

    @Length(max = 10)
    @JsonProperty(value = "biz_no_prefix")
    private String bizNoPrefix;

    @NotNull
    @Min(value = 8)
    @Max(value = 32)
    @JsonProperty(value = "biz_no_suffix_len")
    private Integer bizNoSuffixLen;

    @NotNull
    @InList(value = {"qrcode", "barcode", "dqrcode", "dbarcode", "mdqrcode", "mdbarcode"})
    @JsonProperty(value = "write_off_type")
    private String writeOffType;

    @NotNull
    @JsonProperty(value = "template_style_info")
    private TemplateStyleInfo templateStyleInfo;

    @JsonProperty(value = "template_benefit_info")
    private List<TemplateBenefitInfo> templateBenefitInfos;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getBizNoPrefix() {
        return bizNoPrefix;
    }

    public void setBizNoPrefix(String bizNoPrefix) {
        this.bizNoPrefix = bizNoPrefix;
    }

    public Integer getBizNoSuffixLen() {
        return bizNoSuffixLen;
    }

    public void setBizNoSuffixLen(Integer bizNoSuffixLen) {
        this.bizNoSuffixLen = bizNoSuffixLen;
    }

    public String getWriteOffType() {
        return writeOffType;
    }

    public void setWriteOffType(String writeOffType) {
        this.writeOffType = writeOffType;
    }

    public TemplateStyleInfo getTemplateStyleInfo() {
        return templateStyleInfo;
    }

    public void setTemplateStyleInfo(TemplateStyleInfo templateStyleInfo) {
        this.templateStyleInfo = templateStyleInfo;
    }

    public List<TemplateBenefitInfo> getTemplateBenefitInfos() {
        return templateBenefitInfos;
    }

    public void setTemplateBenefitInfos(List<TemplateBenefitInfo> templateBenefitInfos) {
        this.templateBenefitInfos = templateBenefitInfos;
    }

    public static class Builder {
        private final AlipayMarketingCardTemplateCreateModel instance = new AlipayMarketingCardTemplateCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder requestId(String requestId) {
            instance.setRequestId(requestId);
            return this;
        }

        public Builder cardType(String cardType) {
            instance.setCardType(cardType);
            return this;
        }

        public Builder bizNoPrefix(String bizNoPrefix) {
            instance.setBizNoPrefix(bizNoPrefix);
            return this;
        }

        public Builder bizNoSuffixLen(Integer bizNoSuffixLen) {
            instance.setBizNoSuffixLen(bizNoSuffixLen);
            return this;
        }

        public Builder writeOffType(String writeOffType) {
            instance.setWriteOffType(writeOffType);
            return this;
        }

        public Builder templateStyleInfo(TemplateStyleInfo templateStyleInfo) {
            instance.setTemplateStyleInfo(templateStyleInfo);
            return this;
        }

        public Builder templateBenefitInfos(List<TemplateBenefitInfo> templateBenefitInfos) {
            instance.setTemplateBenefitInfos(templateBenefitInfos);
            return this;
        }

        public AlipayMarketingCardTemplateCreateModel build() {
            AlipayMarketingCardTemplateCreateModel alipayMarketingCardTemplateCreateModel = new AlipayMarketingCardTemplateCreateModel();
            alipayMarketingCardTemplateCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingCardTemplateCreateModel.setBranchId(instance.getBranchId());
            alipayMarketingCardTemplateCreateModel.setRequestId(instance.getRequestId());
            alipayMarketingCardTemplateCreateModel.setCardType(instance.getCardType());
            alipayMarketingCardTemplateCreateModel.setBizNoPrefix(instance.getBizNoPrefix());
            alipayMarketingCardTemplateCreateModel.setBizNoSuffixLen(instance.getBizNoSuffixLen());
            alipayMarketingCardTemplateCreateModel.setWriteOffType(instance.getWriteOffType());
            alipayMarketingCardTemplateCreateModel.setTemplateStyleInfo(instance.getTemplateStyleInfo());
            alipayMarketingCardTemplateCreateModel.setTemplateBenefitInfos(instance.getTemplateBenefitInfos());
            return alipayMarketingCardTemplateCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class TemplateStyleInfo extends BasicModel {
        @NotNull
        @Length(max = 10)
        @JsonProperty(value = "card_show_name")
        private String cardShowName;

        @NotNull
        @Length(max = 1000)
        @JsonProperty(value = "logo_id")
        private String logoId;

        @Length(max = 64)
        private String color;

        @NotNull
        @Length(max = 1000)
        @JsonProperty(value = "background_id")
        private String backgroundId;

        @NotNull
        @Length(max = 32)
        @JsonProperty(value = "bg_color")
        private String bgColor;

        @JsonProperty(value = "front_text_list_enable")
        private Boolean frontTextListEnable;

        @JsonProperty(value = "front_image_enable")
        private Boolean frontImageEnable;

        @Length(max = 4000)
        @JsonProperty(value = "feature_descriptions")
        private List<String> featureDescriptions;

        @Length(max = 100)
        private String slogan;

        @Length(max = 100)
        @JsonProperty(value = "slogan_img_id")
        private String sloganImgId;

        @Length(max = 100)
        @JsonProperty(value = "brand_name")
        private String brandName;

        public String getCardShowName() {
            return cardShowName;
        }

        public void setCardShowName(String cardShowName) {
            this.cardShowName = cardShowName;
        }

        public String getLogoId() {
            return logoId;
        }

        public void setLogoId(String logoId) {
            this.logoId = logoId;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBackgroundId() {
            return backgroundId;
        }

        public void setBackgroundId(String backgroundId) {
            this.backgroundId = backgroundId;
        }

        public String getBgColor() {
            return bgColor;
        }

        public void setBgColor(String bgColor) {
            this.bgColor = bgColor;
        }

        public Boolean getFrontTextListEnable() {
            return frontTextListEnable;
        }

        public void setFrontTextListEnable(Boolean frontTextListEnable) {
            this.frontTextListEnable = frontTextListEnable;
        }

        public Boolean getFrontImageEnable() {
            return frontImageEnable;
        }

        public void setFrontImageEnable(Boolean frontImageEnable) {
            this.frontImageEnable = frontImageEnable;
        }

        public List<String> getFeatureDescriptions() {
            return featureDescriptions;
        }

        public void setFeatureDescriptions(List<String> featureDescriptions) {
            this.featureDescriptions = featureDescriptions;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getSloganImgId() {
            return sloganImgId;
        }

        public void setSloganImgId(String sloganImgId) {
            this.sloganImgId = sloganImgId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }
    }

    public static class TemplateBenefitInfo extends BasicModel {
        @NotNull
        @Length(max = 16)
        private String title;

        @NotNull
        @NotEmpty
        @JsonProperty(value = "benefit_desc")
        private List<String> benefitDesc;

        @NotNull
        @Length(min = 19, max = 19)
        @JsonProperty(value = "start_date")
        private String startDate;

        @NotNull
        @Length(min = 19, max = 19)
        @JsonProperty(value = "end_date")
        private String endDate;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getBenefitDesc() {
            return benefitDesc;
        }

        public void setBenefitDesc(List<String> benefitDesc) {
            this.benefitDesc = benefitDesc;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }
    }
}
