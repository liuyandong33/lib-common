package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.ValidateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AlipayTradeWapPayModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @JsonIgnore
    private String returnUrl;

    @JsonIgnore
    private String notifyUrl;

    @Length(max = 128)
    private String body;

    @NotNull
    @Length(max = 256)
    private String subject;

    @NotNull
    @Length(max = 64)
    @SerializedName(value = "out_trade_no", alternate = "outTradeNo")
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @Length(max = 6)
    @SerializedName(value = "timeout_express", alternate = "timeoutExpress")
    @JsonProperty(value = "timeout_express")
    private String timeoutExpress;

    @Length(max = 32)
    @SerializedName(value = "time_expire", alternate = "timeExpire")
    @JsonProperty(value = "time_expire")
    private String timeExpire;

    @NotNull
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000")
    @SerializedName(value = "total_amount", alternate = "totalAmount")
    @JsonProperty(value = "total_amount")
    private BigDecimal totalAmount;

    @Length(max = 40)
    @SerializedName(value = "auth_token", alternate = "authToken")
    @JsonProperty(value = "auth_token")
    private String authToken;

    @NotNull
    @Length(max = 64)
    @SerializedName(value = "product_code", alternate = "productCode")
    @JsonProperty(value = "product_code")
    private String productCode;

    @InList(value = {"0", "1"})
    @SerializedName(value = "goods_type", alternate = "goodsType")
    @JsonProperty(value = "goods_type")
    private String goodsType;

    @Length(max = 512)
    @SerializedName(value = "passback_params", alternate = "passbackParams")
    @JsonProperty(value = "passback_params")
    private String passbackParams;

    @Length(max = 512)
    @SerializedName(value = "promo_params", alternate = "promoParams")
    @JsonProperty(value = "promo_params")
    private String promoParams;

    @SerializedName(value = "extend_params", alternate = "extendParamsModel")
    @JsonProperty(value = "extend_params")
    private ExtendParamsModel extendParamsModel;

    @Length(max = 128)
    @SerializedName(value = "enable_pay_channels", alternate = "enablePayChannels")
    @JsonProperty(value = "enable_pay_channels")
    private String enablePayChannels;

    @Length(max = 128)
    @SerializedName(value = "disable_pay_channels", alternate = "disablePayChannels")
    @JsonProperty(value = "disable_pay_channels")
    private String disablePayChannels;

    @Length(max = 32)
    @SerializedName(value = "store_id", alternate = "storeId")
    @JsonProperty(value = "store_id")
    private String storeId;

    @Length(max = 400)
    @SerializedName(value = "quit_url", alternate = "quitUrl")
    @JsonProperty(value = "quit_url")
    private String quitUrl;

    @SerializedName(value = "ext_user_info", alternate = "extUserInfoModel")
    @JsonProperty(value = "ext_user_info")
    private ExtUserInfoModel extUserInfoModel;

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

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
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

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getPassbackParams() {
        return passbackParams;
    }

    public void setPassbackParams(String passbackParams) {
        this.passbackParams = passbackParams;
    }

    public String getPromoParams() {
        return promoParams;
    }

    public void setPromoParams(String promoParams) {
        this.promoParams = promoParams;
    }

    public ExtendParamsModel getExtendParamsModel() {
        return extendParamsModel;
    }

    public void setExtendParamsModel(ExtendParamsModel extendParamsModel) {
        this.extendParamsModel = extendParamsModel;
    }

    public String getEnablePayChannels() {
        return enablePayChannels;
    }

    public void setEnablePayChannels(String enablePayChannels) {
        this.enablePayChannels = enablePayChannels;
    }

    public String getDisablePayChannels() {
        return disablePayChannels;
    }

    public void setDisablePayChannels(String disablePayChannels) {
        this.disablePayChannels = disablePayChannels;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getQuitUrl() {
        return quitUrl;
    }

    public void setQuitUrl(String quitUrl) {
        this.quitUrl = quitUrl;
    }

    public ExtUserInfoModel getExtUserInfoModel() {
        return extUserInfoModel;
    }

    public void setExtUserInfoModel(ExtUserInfoModel extUserInfoModel) {
        this.extUserInfoModel = extUserInfoModel;
    }

    public static class ExtendParamsModel extends BasicModel {
        @Length(max = 64)
        @SerializedName(value = "sys_service_provider_id", alternate = "sysServiceProviderId")
        @JsonProperty(value = "sys_service_provider_id")
        private String sysServiceProviderId;

        @InList(value = {"T", "F"})
        @SerializedName(value = "need_buyer_realnamed", alternate = "needBuyerRealNamed")
        @JsonProperty(value = "need_buyer_realnamed")
        private String needBuyerRealNamed;

        @Length(max = 128)
        @SerializedName(value = "TRANS_MEMO", alternate = "transMemo")
        @JsonProperty(value = "TRANS_MEMO")
        private String transMemo;

        @InList(value = {"3", "6", "12"})
        @SerializedName(value = "hb_fq_num", alternate = "hbFqNum")
        @JsonProperty(value = "hb_fq_num")
        private String hbFqNum;

        @InList(value = {"0", "100"})
        @SerializedName(value = "hb_fq_seller_percent", alternate = "hbFqSellerPercent")
        @JsonProperty(value = "hb_fq_seller_percent")
        private String hbFqSellerPercent;

        public String getSysServiceProviderId() {
            return sysServiceProviderId;
        }

        public void setSysServiceProviderId(String sysServiceProviderId) {
            this.sysServiceProviderId = sysServiceProviderId;
        }

        public String getNeedBuyerRealNamed() {
            return needBuyerRealNamed;
        }

        public void setNeedBuyerRealNamed(String needBuyerRealNamed) {
            this.needBuyerRealNamed = needBuyerRealNamed;
        }

        public String getTransMemo() {
            return transMemo;
        }

        public void setTransMemo(String transMemo) {
            this.transMemo = transMemo;
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
    }

    public static class ExtUserInfoModel extends BasicModel {
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

    @Override
    public boolean validate() {
        boolean isValidate = super.validate();
        if (extendParamsModel != null && extendParamsModel.validate()) {
            return false;
        }
        if (extUserInfoModel != null && extUserInfoModel.validate()) {
            return false;
        }
        return super.validate();
    }

    @Override
    public void validateAndThrow() {
        if (extendParamsModel != null) {
            ValidateUtils.isTrue(extendParamsModel.validate(), ApplicationHandler.obtainParameterErrorMessage("extendParams"));
        }

        if (extUserInfoModel != null) {
            ValidateUtils.isTrue(extUserInfoModel.validate(), ApplicationHandler.obtainParameterErrorMessage("extUserInfo"));
        }
        super.validateAndThrow();
    }

    public static class Builder {
        private AlipayTradeWapPayModel instance = new AlipayTradeWapPayModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
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

        public Builder timeoutExpress(String timeoutExpress) {
            instance.setTimeoutExpress(timeoutExpress);
            return this;
        }

        public Builder timeExpire(String timeExpire) {
            instance.setTimeExpire(timeExpire);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder goodsType(String goodsType) {
            instance.setGoodsType(goodsType);
            return this;
        }

        public Builder passbackParams(String passbackParams) {
            instance.setPassbackParams(passbackParams);
            return this;
        }

        public Builder promoParams(String promoParams) {
            instance.setPromoParams(promoParams);
            return this;
        }

        public Builder extendParamsModel(ExtendParamsModel extendParamsModel) {
            instance.setExtendParamsModel(extendParamsModel);
            return this;
        }

        public Builder enablePayChannels(String enablePayChannels) {
            instance.setEnablePayChannels(enablePayChannels);
            return this;
        }

        public Builder disablePayChannels(String disablePayChannels) {
            instance.setDisablePayChannels(disablePayChannels);
            return this;
        }

        public Builder storeId(String storeId) {
            instance.setStoreId(storeId);
            return this;
        }

        public Builder quitUrl(String quitUrl) {
            instance.setQuitUrl(quitUrl);
            return this;
        }

        public Builder extUserInfoModel(ExtUserInfoModel extUserInfoModel) {
            instance.setExtUserInfoModel(extUserInfoModel);
            return this;
        }

        public AlipayTradeWapPayModel build() {
            AlipayTradeWapPayModel alipayTradeWapPayModel = new AlipayTradeWapPayModel();
            alipayTradeWapPayModel.setTenantId(instance.getTenantId());
            alipayTradeWapPayModel.setBranchId(instance.getBranchId());
            alipayTradeWapPayModel.setReturnUrl(instance.getReturnUrl());
            alipayTradeWapPayModel.setNotifyUrl(instance.getNotifyUrl());
            alipayTradeWapPayModel.setBody(instance.getBody());
            alipayTradeWapPayModel.setSubject(instance.getSubject());
            alipayTradeWapPayModel.setOutTradeNo(instance.getOutTradeNo());
            alipayTradeWapPayModel.setTimeoutExpress(instance.getTimeoutExpress());
            alipayTradeWapPayModel.setTimeExpire(instance.getTimeExpire());
            alipayTradeWapPayModel.setTotalAmount(instance.getTotalAmount());
            alipayTradeWapPayModel.setAuthToken(instance.getAuthToken());
            alipayTradeWapPayModel.setProductCode(instance.getProductCode());
            alipayTradeWapPayModel.setGoodsType(instance.getGoodsType());
            alipayTradeWapPayModel.setPassbackParams(instance.getPassbackParams());
            alipayTradeWapPayModel.setPromoParams(instance.getPromoParams());
            alipayTradeWapPayModel.setExtendParamsModel(instance.getExtendParamsModel());
            alipayTradeWapPayModel.setEnablePayChannels(instance.getEnablePayChannels());
            alipayTradeWapPayModel.setDisablePayChannels(instance.getDisablePayChannels());
            alipayTradeWapPayModel.setStoreId(instance.getStoreId());
            alipayTradeWapPayModel.setQuitUrl(instance.getQuitUrl());
            alipayTradeWapPayModel.setExtUserInfoModel(instance.getExtUserInfoModel());
            return alipayTradeWapPayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}