package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public class AlipayTradeAppPayModel extends AlipayBasicModel {
    @Length(max = 6)
    @SerializedName(value = "timeout_express", alternate = "timeoutExpress")
    @JsonProperty(value = "timeout_express")
    private String timeoutExpress;

    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000")
    @SerializedName(value = "total_amount", alternate = "totalAmount")
    @JsonProperty(value = "total_amount")
    private BigDecimal totalAmount;

    @Length(max = 16)
    @SerializedName(value = "seller_id", alternate = "sellerId")
    @JsonProperty(value = "seller_id")
    private String sellerId;

    @Length(max = 64)
    @SerializedName(value = "product_code", alternate = "productCode")
    @JsonProperty(value = "product_code")
    private String productCode;

    @Length(max = 128)
    private String body;

    @Length(max = 256)
    private String subject;

    @Length(max = 64)
    @SerializedName(value = "out_trade_no", alternate = "outTradeNo")
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @Length(min = 15, max = 15)
    @SerializedName(value = "time_expire", alternate = "timeExpire")
    @JsonProperty(value = "time_expire")
    private String timeExpire;

    @InList(value = {"0", "1"})
    @SerializedName(value = "goods_type", alternate = "goodsType")
    @JsonProperty(value = "goods_type")
    private String goodsType;

    @Length(max = 512)
    @SerializedName(value = "promo_params", alternate = "promoParams")
    @JsonProperty(value = "promo_params")
    private String promoParams;

    @Length(max = 512)
    @SerializedName(value = "passback_params", alternate = "passbackParams")
    @JsonProperty(value = "passback_params")
    private String passbackParams;

    @SerializedName(value = "royalty_info", alternate = "royaltyInfo")
    @JsonProperty(value = "royalty_info")
    private RoyaltyInfo royaltyInfo;

    @SerializedName(value = "extend_params", alternate = "extendParams")
    @JsonProperty(value = "extend_params")
    private ExtendParams extendParams;

    @SerializedName(value = "sub_merchant", alternate = "subMerchant")
    @JsonProperty(value = "sub_merchant")
    private SubMerchant subMerchant;

    @Length(max = 128)
    @SerializedName(value = "enable_pay_channels", alternate = "enablePayChannels")
    @JsonProperty(value = "enable_pay_channels")
    private String enablePayChannels;

    @Length(max = 32)
    @SerializedName(value = "store_id", alternate = "storeId")
    @JsonProperty(value = "store_id")
    private String storeId;

    @Length(max = 128)
    @SerializedName(value = "specified_channel", alternate = "specifiedChannel")
    @JsonProperty(value = "specified_channel")
    private String specifiedChannel;

    @Length(max = 128)
    @SerializedName(value = "disable_pay_channels", alternate = "disablePayChannels")
    @JsonProperty(value = "disable_pay_channels")
    private String disablePayChannels;

    @SerializedName(value = "settle_info", alternate = "settleInfo")
    @JsonProperty(value = "settle_info")
    private SettleInfo settleInfo;

    @SerializedName(value = "invoice_info", alternate = "invoiceInfo")
    @JsonProperty(value = "invoice_info")
    private InvoiceInfo invoiceInfo;

    @SerializedName(value = "ext_user_info", alternate = "extUserInfo")
    @JsonProperty(value = "ext_user_info")
    private ExtUserInfo extUserInfo;

    @Length(max = 512)
    @SerializedName(value = "business_params", alternate = "businessParams")
    @JsonProperty(value = "business_params")
    private String businessParams;

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getPromoParams() {
        return promoParams;
    }

    public void setPromoParams(String promoParams) {
        this.promoParams = promoParams;
    }

    public String getPassbackParams() {
        return passbackParams;
    }

    public void setPassbackParams(String passbackParams) {
        this.passbackParams = passbackParams;
    }

    public RoyaltyInfo getRoyaltyInfo() {
        return royaltyInfo;
    }

    public void setRoyaltyInfo(RoyaltyInfo royaltyInfo) {
        this.royaltyInfo = royaltyInfo;
    }

    public ExtendParams getExtendParams() {
        return extendParams;
    }

    public void setExtendParams(ExtendParams extendParams) {
        this.extendParams = extendParams;
    }

    public SubMerchant getSubMerchant() {
        return subMerchant;
    }

    public void setSubMerchant(SubMerchant subMerchant) {
        this.subMerchant = subMerchant;
    }

    public String getEnablePayChannels() {
        return enablePayChannels;
    }

    public void setEnablePayChannels(String enablePayChannels) {
        this.enablePayChannels = enablePayChannels;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSpecifiedChannel() {
        return specifiedChannel;
    }

    public void setSpecifiedChannel(String specifiedChannel) {
        this.specifiedChannel = specifiedChannel;
    }

    public String getDisablePayChannels() {
        return disablePayChannels;
    }

    public void setDisablePayChannels(String disablePayChannels) {
        this.disablePayChannels = disablePayChannels;
    }

    public SettleInfo getSettleInfo() {
        return settleInfo;
    }

    public void setSettleInfo(SettleInfo settleInfo) {
        this.settleInfo = settleInfo;
    }

    public InvoiceInfo getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(InvoiceInfo invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }

    public ExtUserInfo getExtUserInfo() {
        return extUserInfo;
    }

    public void setExtUserInfo(ExtUserInfo extUserInfo) {
        this.extUserInfo = extUserInfo;
    }

    public String getBusinessParams() {
        return businessParams;
    }

    public void setBusinessParams(String businessParams) {
        this.businessParams = businessParams;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if (royaltyInfo != null) {
            ApplicationHandler.isTrue(royaltyInfo.validate(), "royaltyInfo");
            List<RoyaltyDetailInfo> royaltyDetailInfos = royaltyInfo.royaltyDetailInfos;
            for (RoyaltyDetailInfo royaltyDetailInfo : royaltyDetailInfos) {
                ApplicationHandler.isTrue(royaltyDetailInfo.validate(), "royaltyInfo");
            }
        }

        if (extendParams != null) {
            ApplicationHandler.isTrue(extendParams.validate(), "extendParams");
        }

        if (subMerchant != null) {
            ApplicationHandler.isTrue(subMerchant.validate(), "subMerchant");
        }

        if (settleInfo != null) {
            ApplicationHandler.isTrue(settleInfo.validate(), "settleInfo");
            List<SettleDetailInfo> settleDetailInfos = settleInfo.settleDetailInfos;
            for (SettleDetailInfo settleDetailInfo : settleDetailInfos) {
                ApplicationHandler.isTrue(settleDetailInfo.validate(), "settleInfo");
            }
        }

        if (invoiceInfo != null) {
            ApplicationHandler.isTrue(invoiceInfo.validate(), "invoiceInfo");
        }

        if (extUserInfo != null) {
            ApplicationHandler.isTrue(extUserInfo.validate(), "extUserInfo");
        }
    }

    public static class RoyaltyInfo extends BasicModel {
        @InList(value = {"ROYALTY"})
        @SerializedName(value = "royalty_type", alternate = "royaltyType")
        @JsonProperty(value = "royalty_type")
        private String royaltyType;

        @NotNull
        @NotEmpty
        @SerializedName(value = "royalty_detail_infos", alternate = "royaltyDetailInfos")
        @JsonProperty(value = "royalty_detail_infos")
        private List<RoyaltyDetailInfo> royaltyDetailInfos;

        public String getRoyaltyType() {
            return royaltyType;
        }

        public void setRoyaltyType(String royaltyType) {
            this.royaltyType = royaltyType;
        }

        public List<RoyaltyDetailInfo> getRoyaltyDetailInfos() {
            return royaltyDetailInfos;
        }

        public void setRoyaltyDetailInfos(List<RoyaltyDetailInfo> royaltyDetailInfos) {
            this.royaltyDetailInfos = royaltyDetailInfos;
        }
    }

    public static class RoyaltyDetailInfo extends BasicModel {
        @Min(1)
        @Max(999999999)
        @SerializedName(value = "serial_no", alternate = "serialNo")
        @JsonProperty(value = "serial_no")
        private Integer serialNo;

        @InList(value = {"userId", "bankIndex", "storeId"})
        @SerializedName(value = "trans_in_type", alternate = "transInType")
        @JsonProperty(value = "trans_in_type")
        private String transInType;

        @NotNull
        @Length(max = 32)
        @SerializedName(value = "batch_no", alternate = "batchNo")
        @JsonProperty(value = "batch_no")
        private String batchNo;

        @Length(max = 64)
        @SerializedName(value = "out_relation_id", alternate = "outRelationId")
        @JsonProperty(value = "out_relation_id")
        private String outRelationId;

        @NotNull
        @InList(value = {"userId"})
        @SerializedName(value = "trans_out_type", alternate = "transOutType")
        @JsonProperty(value = "trans_out_type")
        private String transOutType;

        @NotNull
        @Length(min = 16, max = 16)
        @SerializedName(value = "trans_out", alternate = "transOut")
        @JsonProperty(value = "transOut")
        private String transOut;

        @NotNull
        @Length(max = 28)
        @SerializedName(value = "trans_in", alternate = "transIn")
        @JsonProperty(value = "trans_in")
        private String transIn;

        @NotNull
        @DecimalMin(value = "0.01")
        @DecimalMax(value = "999999999")
        private BigDecimal amount;

        @Length(max = 1000)
        private String desc;

        @Length(min = 1, max = 3)
        @SerializedName(value = "amount_percentage", alternate = "amountPercentage")
        @JsonProperty(value = "amount_percentage")
        private String amountPercentage;

        public Integer getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(Integer serialNo) {
            this.serialNo = serialNo;
        }

        public String getTransInType() {
            return transInType;
        }

        public void setTransInType(String transInType) {
            this.transInType = transInType;
        }

        public String getBatchNo() {
            return batchNo;
        }

        public void setBatchNo(String batchNo) {
            this.batchNo = batchNo;
        }

        public String getOutRelationId() {
            return outRelationId;
        }

        public void setOutRelationId(String outRelationId) {
            this.outRelationId = outRelationId;
        }

        public String getTransOutType() {
            return transOutType;
        }

        public void setTransOutType(String transOutType) {
            this.transOutType = transOutType;
        }

        public String getTransOut() {
            return transOut;
        }

        public void setTransOut(String transOut) {
            this.transOut = transOut;
        }

        public String getTransIn() {
            return transIn;
        }

        public void setTransIn(String transIn) {
            this.transIn = transIn;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getAmountPercentage() {
            return amountPercentage;
        }

        public void setAmountPercentage(String amountPercentage) {
            this.amountPercentage = amountPercentage;
        }
    }

    public static class ExtendParams extends BasicModel {
        @Length(max = 64)
        @SerializedName(value = "sys_service_provider_id", alternate = "sysServiceProviderId")
        @JsonProperty(value = "sys_service_provider_id")
        private String sysServiceProviderId;

        @Length(max = 5)
        @SerializedName(value = "hb_fq_num", alternate = "hbFqNum")
        @JsonProperty(value = "hb_fq_num")
        private String hbFqNum;

        @Length(max = 3)
        @SerializedName(value = "hb_fq_seller_percent", alternate = "hbFqSellerPercent")
        @JsonProperty(value = "hb_fq_seller_percent")
        private String hbFqSellerPercent;

        @Length(max = 512)
        @SerializedName(value = "industry_reflux_info", alternate = "industryRefluxInfo")
        @JsonProperty(value = "industry_reflux_info")
        private String industryRefluxInfo;

        @Length(max = 32)
        @SerializedName(value = "card_type", alternate = "cardType")
        @JsonProperty(value = "card_type")
        private String cardType;

        public String getSysServiceProviderId() {
            return sysServiceProviderId;
        }

        public void setSysServiceProviderId(String sysServiceProviderId) {
            this.sysServiceProviderId = sysServiceProviderId;
        }

        public String getHbFqNum() {
            return hbFqNum;
        }

        public void setHbFqNum(String hbFqNum) {
            this.hbFqNum = hbFqNum;
        }

        public String getHbFqSellerPercent() {
            return hbFqSellerPercent;
        }

        public void setHbFqSellerPercent(String hbFqSellerPercent) {
            this.hbFqSellerPercent = hbFqSellerPercent;
        }

        public String getIndustryRefluxInfo() {
            return industryRefluxInfo;
        }

        public void setIndustryRefluxInfo(String industryRefluxInfo) {
            this.industryRefluxInfo = industryRefluxInfo;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }
    }

    public static class SubMerchant extends BasicModel {
        @NotNull
        @Length(max = 11)
        @SerializedName(value = "merchant_id", alternate = "merchantId")
        @JsonProperty(value = "merchant_id")
        private String merchantId;

        @InList(value = {"alipay", "merchant"})
        @SerializedName(value = "merchant_type", alternate = "merchantType")
        @JsonProperty(value = "merchant_type")
        private String merchantType;

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getMerchantType() {
            return merchantType;
        }

        public void setMerchantType(String merchantType) {
            this.merchantType = merchantType;
        }
    }

    public static class SettleInfo extends BasicModel {
        @NotNull
        @NotEmpty
        @SerializedName(value = "settle_detail_infos", alternate = "settleDetailInfos")
        @JsonProperty(value = "settle_detail_infos")
        private List<SettleDetailInfo> settleDetailInfos;

        public List<SettleDetailInfo> getSettleDetailInfos() {
            return settleDetailInfos;
        }

        public void setSettleDetailInfos(List<SettleDetailInfo> settleDetailInfos) {
            this.settleDetailInfos = settleDetailInfos;
        }
    }

    public static class SettleDetailInfo extends BasicModel {
        @NotNull
        @Length(max = 64)
        @SerializedName(value = "trans_in_type", alternate = "transInType")
        @JsonProperty(value = "trans_in_type")
        private String transInType;

        @NotNull
        @Length(max = 64)
        @SerializedName(value = "trans_in", alternate = "transIn")
        @JsonProperty(value = "trans_in")
        private String transIn;

        @Length(max = 64)
        @SerializedName(value = "summary_dimension", alternate = "summaryDimension")
        @JsonProperty(value = "summary_dimension")
        private String summaryDimension;

        @NotNull
        @DecimalMin(value = "0.01")
        @DecimalMax(value = "999999999")
        private BigDecimal amount;

        public String getTransInType() {
            return transInType;
        }

        public void setTransInType(String transInType) {
            this.transInType = transInType;
        }

        public String getTransIn() {
            return transIn;
        }

        public void setTransIn(String transIn) {
            this.transIn = transIn;
        }

        public String getSummaryDimension() {
            return summaryDimension;
        }

        public void setSummaryDimension(String summaryDimension) {
            this.summaryDimension = summaryDimension;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
    }

    public static class InvoiceInfo extends BasicModel {
        @NotNull
        @SerializedName(value = "key_info", alternate = "keyInfo")
        @JsonProperty(value = "key_info")
        private List<InvoiceKeyInfo> keyInfo;

        @NotNull
        @Length(max = 400)
        private String details;

        public List<InvoiceKeyInfo> getKeyInfo() {
            return keyInfo;
        }

        public void setKeyInfo(List<InvoiceKeyInfo> keyInfo) {
            this.keyInfo = keyInfo;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    public static class InvoiceKeyInfo extends BasicModel {
        @NotNull
        @SerializedName(value = "is_support_invoice", alternate = "isSupportInvoice")
        @JsonProperty(value = "is_support_invoice")
        private Boolean isSupportInvoice;

        @NotNull
        @Length(max = 80)
        @SerializedName(value = "invoice_merchant_name", alternate = "invoiceMerchantName")
        @JsonProperty(value = "invoice_merchant_name")
        private String invoiceMerchantName;

        @NotNull
        @Length(max = 30)
        @SerializedName(value = "tax_num", alternate = "taxNum")
        @JsonProperty(value = "tax_num")
        private String taxNum;

        public Boolean getSupportInvoice() {
            return isSupportInvoice;
        }

        public void setSupportInvoice(Boolean supportInvoice) {
            isSupportInvoice = supportInvoice;
        }

        public String getInvoiceMerchantName() {
            return invoiceMerchantName;
        }

        public void setInvoiceMerchantName(String invoiceMerchantName) {
            this.invoiceMerchantName = invoiceMerchantName;
        }

        public String getTaxNum() {
            return taxNum;
        }

        public void setTaxNum(String taxNum) {
            this.taxNum = taxNum;
        }
    }

    public static class ExtUserInfo extends BasicModel {
        @Length(max = 16)
        private String name;

        @Length(max = 20)
        private String mobile;

        @InList(value = {"IDENTITY_CARD", "PASSPORT", "OFFICER_CARD", "SOLDIER_CARD", "HOKOU"})
        @SerializedName(value = "cert_type", alternate = "certType")
        @JsonProperty(value = "cert_type")
        private String certType;

        @Length(max = 64)
        @SerializedName(value = "cert_no", alternate = "certNo")
        @JsonProperty(value = "cert_no")
        private String certNo;

        @Length(max = 3)
        @SerializedName(value = "min_age", alternate = "minAge")
        @JsonProperty(value = "min_age")
        private String minAge;

        @InList(value = {"T", "F"})
        @SerializedName(value = "fix_buyer", alternate = "fixBuyer")
        @JsonProperty(value = "fix_buyer")
        private String fixBuyer;

        @InList(value = {"T", "F"})
        @SerializedName(value = "need_check_info", alternate = "needCheckInfo")
        @JsonProperty(value = "need_check_info")
        private String needCheckInfo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getCertType() {
            return certType;
        }

        public void setCertType(String certType) {
            this.certType = certType;
        }

        public String getCertNo() {
            return certNo;
        }

        public void setCertNo(String certNo) {
            this.certNo = certNo;
        }

        public String getMinAge() {
            return minAge;
        }

        public void setMinAge(String minAge) {
            this.minAge = minAge;
        }

        public String getFixBuyer() {
            return fixBuyer;
        }

        public void setFixBuyer(String fixBuyer) {
            this.fixBuyer = fixBuyer;
        }

        public String getNeedCheckInfo() {
            return needCheckInfo;
        }

        public void setNeedCheckInfo(String needCheckInfo) {
            this.needCheckInfo = needCheckInfo;
        }
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayTradeAppPayModel> {
        public Builder timeoutExpress(String timeoutExpress) {
            instance.setTimeoutExpress(timeoutExpress);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder sellerId(String sellerId) {
            instance.setSellerId(sellerId);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder body(String body) {
            instance.setBody(body);
            return this;
        }

        public Builder subject(String subject) {
            instance.setSubject(subject);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder timeExpire(String timeExpire) {
            instance.setTimeExpire(timeExpire);
            return this;
        }

        public Builder goodsType(String goodsType) {
            instance.setGoodsType(goodsType);
            return this;
        }

        public Builder promoParams(String promoParams) {
            instance.setPromoParams(promoParams);
            return this;
        }

        public Builder passbackParams(String passbackParams) {
            instance.setPassbackParams(passbackParams);
            return this;
        }

        public Builder royaltyInfo(RoyaltyInfo royaltyInfo) {
            instance.setRoyaltyInfo(royaltyInfo);
            return this;
        }

        public Builder extendParams(ExtendParams extendParams) {
            instance.setExtendParams(extendParams);
            return this;
        }

        public Builder subMerchant(SubMerchant subMerchant) {
            instance.setSubMerchant(subMerchant);
            return this;
        }

        public Builder enablePayChannels(String enablePayChannels) {
            instance.setEnablePayChannels(enablePayChannels);
            return this;
        }

        public Builder storeId(String storeId) {
            instance.setStoreId(storeId);
            return this;
        }

        public Builder specifiedChannel(String specifiedChannel) {
            instance.setSpecifiedChannel(specifiedChannel);
            return this;
        }

        public Builder disablePayChannels(String disablePayChannels) {
            instance.setDisablePayChannels(disablePayChannels);
            return this;
        }

        public Builder settleInfo(SettleInfo settleInfo) {
            instance.setSettleInfo(settleInfo);
            return this;
        }

        public Builder invoiceInfo(InvoiceInfo invoiceInfo) {
            instance.setInvoiceInfo(invoiceInfo);
            return this;
        }

        public Builder extUserInfo(ExtUserInfo extUserInfo) {
            instance.setExtUserInfo(extUserInfo);
            return this;
        }

        public Builder businessParams(String businessParams) {
            instance.setBusinessParams(businessParams);
            return this;
        }

        @Override
        public AlipayTradeAppPayModel build() {
            AlipayTradeAppPayModel alipayTradeAppPayModel = super.build();
            alipayTradeAppPayModel.setTimeoutExpress(instance.getTimeoutExpress());
            alipayTradeAppPayModel.setTotalAmount(instance.getTotalAmount());
            alipayTradeAppPayModel.setSellerId(instance.getSellerId());
            alipayTradeAppPayModel.setProductCode(instance.getProductCode());
            alipayTradeAppPayModel.setBody(instance.getBody());
            alipayTradeAppPayModel.setSubject(instance.getSubject());
            alipayTradeAppPayModel.setOutTradeNo(instance.getOutTradeNo());
            alipayTradeAppPayModel.setTimeExpire(instance.getTimeExpire());
            alipayTradeAppPayModel.setGoodsType(instance.getGoodsType());
            alipayTradeAppPayModel.setPromoParams(instance.getPromoParams());
            alipayTradeAppPayModel.setPassbackParams(instance.getPassbackParams());
            alipayTradeAppPayModel.setRoyaltyInfo(instance.getRoyaltyInfo());
            alipayTradeAppPayModel.setExtendParams(instance.getExtendParams());
            alipayTradeAppPayModel.setSubMerchant(instance.getSubMerchant());
            alipayTradeAppPayModel.setEnablePayChannels(instance.getEnablePayChannels());
            alipayTradeAppPayModel.setDisablePayChannels(instance.getDisablePayChannels());
            alipayTradeAppPayModel.setSettleInfo(instance.getSettleInfo());
            alipayTradeAppPayModel.setInvoiceInfo(instance.getInvoiceInfo());
            alipayTradeAppPayModel.setExtUserInfo(instance.getExtUserInfo());
            alipayTradeAppPayModel.setBusinessParams(instance.getBusinessParams());
            return alipayTradeAppPayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
