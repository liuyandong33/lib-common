package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.ValidateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

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
    private String outTradeNo;

    @Length(max = 6)
    @SerializedName(value = "timeout_express", alternate = "timeoutExpress")
    private String timeoutExpress;

    @Length(max = 32)
    @SerializedName(value = "time_expire", alternate = "timeExpire")
    private String timeExpire;

    @NotNull
    @Length(max = 9)
    @SerializedName(value = "total_amount", alternate = "totalAmount")
    private String totalAmount;

    @Length(max = 40)
    @SerializedName(value = "auth_token", alternate = "authToken")
    private String authToken;

    @NotNull
    @Length(max = 64)
    @SerializedName(value = "product_code", alternate = "productCode")
    private String productCode;

    @InList(value = {"0", "1"})
    @SerializedName(value = "goods_type", alternate = "goodsType")
    private String goodsType;

    @Length(max = 512)
    @SerializedName(value = "passback_params", alternate = "passbackParams")
    private String passbackParams;

    @Length(max = 512)
    @SerializedName(value = "promo_params", alternate = "promoParams")
    private String promoParams;

    @SerializedName(value = "extend_params", alternate = "extendParamsModel")
    private ExtendParamsModel extendParamsModel;

    @Length(max = 128)
    @SerializedName(value = "enable_pay_channels", alternate = "enablePayChannels")
    private String enablePayChannels;

    @Length(max = 128)
    @SerializedName(value = "disable_pay_channels", alternate = "disablePayChannels")
    private String disablePayChannels;

    @Length(max = 32)
    @SerializedName(value = "store_id", alternate = "storeId")
    private String storeId;

    @Length(max = 400)
    @SerializedName(value = "quit_url", alternate = "quitUrl")
    private String quitUrl;

    @SerializedName(value = "ext_user_info", alternate = "extUserInfoModel")
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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
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
        private String sysServiceProviderId;

        @InList(value = {"T", "F"})
        @SerializedName(value = "needBuyerRealnamed", alternate = "needBuyerRealNamed")
        private String needBuyerRealNamed;

        @Length(max = 128)
        @SerializedName(value = "TRANS_MEMO", alternate = "transMemo")
        private String transMemo;

        @InList(value = {"3", "6", "12"})
        @SerializedName(value = "hb_fq_num", alternate = "hbFqNum")
        private String hbFqNum;

        @InList(value = {"0", "100"})
        @SerializedName(value = "hb_fq_seller_percent", alternate = "hbFqSellerPercent")
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
        private String certType;

        @Length(max = 64)
        @SerializedName(value = "cert_no", alternate = "certNo")
        private String certNo;

        @Length(max = 3)
        @SerializedName(value = "min_age", alternate = "minAge")
        private String minAge;

        @InList(value = {"T", "F"})
        @SerializedName(value = "fix_buyer", alternate = "fixBuyer")
        private String fixBuyer;

        @InList(value = {"T", "F"})
        @SerializedName(value = "need_check_info", alternate = "needCheckInfo")
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

        public Builder totalAmount(String totalAmount) {
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
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}