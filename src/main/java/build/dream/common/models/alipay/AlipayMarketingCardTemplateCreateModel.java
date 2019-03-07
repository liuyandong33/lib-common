package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayMarketingCardTemplateCreateModel extends AlipayBasicModel {
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

    @NotEmpty
    @JsonProperty(value = "column_info_list")
    private List<ColumnInfo> columnInfoList;

    @NotEmpty
    @JsonProperty(value = "field_rule_list")
    private List<FieldRule> fieldRuleList;

    @JsonProperty(value = "card_action_list")
    private List<CardAction> cardActionList;

    @JsonProperty(value = "open_card_conf")
    private OpenCardConf openCardConf;

    @JsonProperty(value = "service_label_list")
    private List<String> serviceLabelList;

    @JsonProperty(value = "shop_ids")
    private List<String> shopIds;

    @JsonProperty(value = "pub_channels")
    private List<PubChannel> pubChannels;

    @JsonProperty(value = "card_level_conf")
    private List<CardLevelConf> cardLevelConfs;

    @JsonProperty(value = "mdcode_notify_conf")
    private MdcodeNotifyConf mdcodeNotifyConf;

    @Length(max = 20)
    @JsonProperty(value = "card_spec_tag")
    private String cardSpecTag;

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

    public List<ColumnInfo> getColumnInfoList() {
        return columnInfoList;
    }

    public void setColumnInfoList(List<ColumnInfo> columnInfoList) {
        this.columnInfoList = columnInfoList;
    }

    public List<FieldRule> getFieldRuleList() {
        return fieldRuleList;
    }

    public void setFieldRuleList(List<FieldRule> fieldRuleList) {
        this.fieldRuleList = fieldRuleList;
    }

    public List<CardAction> getCardActionList() {
        return cardActionList;
    }

    public void setCardActionList(List<CardAction> cardActionList) {
        this.cardActionList = cardActionList;
    }

    public OpenCardConf getOpenCardConf() {
        return openCardConf;
    }

    public void setOpenCardConf(OpenCardConf openCardConf) {
        this.openCardConf = openCardConf;
    }

    public List<String> getServiceLabelList() {
        return serviceLabelList;
    }

    public void setServiceLabelList(List<String> serviceLabelList) {
        this.serviceLabelList = serviceLabelList;
    }

    public List<String> getShopIds() {
        return shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        this.shopIds = shopIds;
    }

    public List<PubChannel> getPubChannels() {
        return pubChannels;
    }

    public void setPubChannels(List<PubChannel> pubChannels) {
        this.pubChannels = pubChannels;
    }

    public List<CardLevelConf> getCardLevelConfs() {
        return cardLevelConfs;
    }

    public void setCardLevelConfs(List<CardLevelConf> cardLevelConfs) {
        this.cardLevelConfs = cardLevelConfs;
    }

    public String getCardSpecTag() {
        return cardSpecTag;
    }

    public void setCardSpecTag(String cardSpecTag) {
        this.cardSpecTag = cardSpecTag;
    }

    public MdcodeNotifyConf getMdcodeNotifyConf() {
        return mdcodeNotifyConf;
    }

    public void setMdcodeNotifyConf(MdcodeNotifyConf mdcodeNotifyConf) {
        this.mdcodeNotifyConf = mdcodeNotifyConf;
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

        public Builder columnInfoList(List<ColumnInfo> columnInfoList) {
            instance.setColumnInfoList(columnInfoList);
            return this;
        }

        public Builder fieldRuleList(List<FieldRule> fieldRuleList) {
            instance.setFieldRuleList(fieldRuleList);
            return this;
        }

        public Builder cardActionList(List<CardAction> cardActionList) {
            instance.setCardActionList(cardActionList);
            return this;
        }

        public Builder openCardConf(OpenCardConf openCardConf) {
            instance.setOpenCardConf(openCardConf);
            return this;
        }

        public Builder serviceLabelList(List<String> serviceLabelList) {
            instance.setServiceLabelList(serviceLabelList);
            return this;
        }

        public Builder shopIds(List<String> shopIds) {
            instance.setShopIds(shopIds);
            return this;
        }

        public Builder pubChannels(List<PubChannel> pubChannels) {
            instance.setPubChannels(pubChannels);
            return this;
        }

        public Builder cardLevelConfs(List<CardLevelConf> cardLevelConfs) {
            instance.setCardLevelConfs(cardLevelConfs);
            return this;
        }

        public Builder mdcodeNotifyConf(MdcodeNotifyConf mdcodeNotifyConf) {
            instance.setMdcodeNotifyConf(mdcodeNotifyConf);
            return this;
        }

        public Builder cardSpecTag(String cardSpecTag) {
            instance.setCardSpecTag(cardSpecTag);
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
            alipayMarketingCardTemplateCreateModel.setColumnInfoList(instance.getColumnInfoList());
            alipayMarketingCardTemplateCreateModel.setFieldRuleList(instance.getFieldRuleList());
            alipayMarketingCardTemplateCreateModel.setCardActionList(instance.getCardActionList());
            alipayMarketingCardTemplateCreateModel.setOpenCardConf(instance.getOpenCardConf());
            alipayMarketingCardTemplateCreateModel.setServiceLabelList(instance.getServiceLabelList());
            alipayMarketingCardTemplateCreateModel.setShopIds(instance.getShopIds());
            alipayMarketingCardTemplateCreateModel.setPubChannels(instance.getPubChannels());
            alipayMarketingCardTemplateCreateModel.setCardLevelConfs(instance.getCardLevelConfs());
            alipayMarketingCardTemplateCreateModel.setMdcodeNotifyConf(instance.getMdcodeNotifyConf());
            alipayMarketingCardTemplateCreateModel.setCardSpecTag(instance.getCardSpecTag());
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

    public static class ColumnInfo extends BasicModel {
        @NotNull
        @Length(max = 32)
        private String code;

        @InList(value = {"openNative", "openWeb", "staticinfo"})
        @JsonProperty(value = "operate_type")
        private String operateType;

        @NotNull
        @Length(max = 16)
        private String title;

        @Length(max = 16)
        private String value;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getOperateType() {
            return operateType;
        }

        public void setOperateType(String operateType) {
            this.operateType = operateType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class FieldRule extends BasicModel {
        @NotNull
        @InList(value = {"Balance", "Point", "Level", "OpenDate", "ValidDate"})
        @JsonProperty(value = "field_name")
        private String fieldName;

        @NotNull
        @InList(value = {"ASSIGN_FROM_REQUEST", "DATE_IN_FUTURE", "CONST"})
        @JsonProperty(value = "rule_name")
        private String ruleName;

        @NotNull
        @Length(max = 512)
        @JsonProperty(value = "rule_value")
        private String ruleValue;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getRuleName() {
            return ruleName;
        }

        public void setRuleName(String ruleName) {
            this.ruleName = ruleName;
        }

        public String getRuleValue() {
            return ruleValue;
        }

        public void setRuleValue(String ruleValue) {
            this.ruleValue = ruleValue;
        }
    }

    public static class CardAction extends BasicModel {
        @NotNull
        @Length(max = 32)
        private String code;

        @NotNull
        @Length(max = 6)
        private String text;

        @NotNull
        @Length(max = 1024)
        private String url;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class OpenCardConf extends BasicModel {
        @NotNull
        @InList(value = {"ISV", "MER"})
        @JsonProperty(value = "open_card_source_type")
        private String openCardSourceType;

        @NotNull
        @Length(max = 32)
        @JsonProperty(value = "source_app_id")
        private String sourceAppId;

        @NotNull
        @Length(max = 256)
        @JsonProperty(value = "open_card_url")
        private String openCardUrl;

        @Length(max = 4000)
        private String conf;

        public String getOpenCardSourceType() {
            return openCardSourceType;
        }

        public void setOpenCardSourceType(String openCardSourceType) {
            this.openCardSourceType = openCardSourceType;
        }

        public String getSourceAppId() {
            return sourceAppId;
        }

        public void setSourceAppId(String sourceAppId) {
            this.sourceAppId = sourceAppId;
        }

        public String getOpenCardUrl() {
            return openCardUrl;
        }

        public void setOpenCardUrl(String openCardUrl) {
            this.openCardUrl = openCardUrl;
        }

        public String getConf() {
            return conf;
        }

        public void setConf(String conf) {
            this.conf = conf;
        }
    }

    public static class PubChannel extends BasicModel {
        @NotNull
        @InList(value = {"SHOP_DETAIL", "PAYMENT_RESULT"})
        @JsonProperty(value = "pub_channel")
        private String pubChannel;

        @NotNull
        @Length(max = 1024)
        @JsonProperty(value = "ext_info")
        private String extInfo;

        public String getPubChannel() {
            return pubChannel;
        }

        public void setPubChannel(String pubChannel) {
            this.pubChannel = pubChannel;
        }

        public String getExtInfo() {
            return extInfo;
        }

        public void setExtInfo(String extInfo) {
            this.extInfo = extInfo;
        }
    }

    public static class CardLevelConf extends BasicModel {
        @NotNull
        @Length(max = 64)
        private String level;

        @NotNull
        @Length(max = 64)
        @JsonProperty(value = "level_show_name")
        private String levelShowName;

        @NotNull
        @Length(max = 64)
        @JsonProperty(value = "level_icon")
        private String levelIcon;

        @NotNull
        @Length(max = 4000)
        @JsonProperty(value = "level_desc")
        private String levelDesc;

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getLevelShowName() {
            return levelShowName;
        }

        public void setLevelShowName(String levelShowName) {
            this.levelShowName = levelShowName;
        }

        public String getLevelIcon() {
            return levelIcon;
        }

        public void setLevelIcon(String levelIcon) {
            this.levelIcon = levelIcon;
        }

        public String getLevelDesc() {
            return levelDesc;
        }

        public void setLevelDesc(String levelDesc) {
            this.levelDesc = levelDesc;
        }
    }

    public static class MdcodeNotifyConf extends BasicModel {
        @NotNull
        @Length(max = 1024)
        private String url;

        @Length(max = 1024)
        @JsonProperty(value = "ext_params")
        private String extParams;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getExtParams() {
            return extParams;
        }

        public void setExtParams(String extParams) {
            this.extParams = extParams;
        }
    }
}
