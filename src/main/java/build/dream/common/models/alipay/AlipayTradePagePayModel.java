package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AlipayTradePagePayModel extends BasicModel {
    private static final String[] GOODS_TYPES = {"0", "1"};
    private static final String[] QR_PAY_MODES = {"0", "1", "2", "3", "4"};
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

    @JsonIgnore
    private String appAuthToken;

    @NotNull
    @Length(max = 64)
    @SerializedName(value = "out_trade_no", alternate = "outTradeNo")
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @NotNull
    @Length(max = 64)
    @SerializedName(value = "product_code", alternate = "productCode")
    @JsonProperty(value = "product_code")
    private String productCode;

    @NotNull
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000")
    @SerializedName(value = "total_amount", alternate = "totalAmount")
    @JsonProperty(value = "total_amount")
    private BigDecimal totalAmount;

    @NotNull
    @Length(max = 256)
    private String subject;

    @Length(max = 128)
    private String body;

    @SerializedName(value = "goods_detail", alternate = "goodsDetail")
    @JsonProperty(value = "goods_detail")
    private String goodsDetail;

    @Length(max = 512)
    @SerializedName(value = "passback_params", alternate = "passbackParams")
    @JsonProperty(value = "passback_params")
    private String passbackParams;

    @SerializedName(value = "goods_type", alternate = "goodsType")
    @JsonProperty(value = "goods_type")
    private String goodsType;

    @Length(max = 6)
    @SerializedName(value = "timeout_express", alternate = "timeoutExpress")
    @JsonProperty(value = "timeout_express")
    private String timeoutExpress;

    @Length(max = 128)
    @SerializedName(value = "enable_pay_channels", alternate = "enablePayChannels")
    @JsonProperty(value = "enable_pay_channels")
    private String enablePayChannels;

    @Length(max = 128)
    @SerializedName(value = "disable_pay_channels", alternate = "disablePayChannels")
    @JsonProperty(value = "disable_pay_channels")
    private String disablePayChannels;

    @Length(max = 40)
    @SerializedName(value = "auth_token", alternate = "authToken")
    @JsonProperty(value = "auth_token")
    private String authToken;

    @SerializedName(value = "qr_pay_mode", alternate = "qrPayMode")
    @JsonProperty(value = "qr_pay_mode")
    private String qrPayMode;

    @SerializedName(value = "qrcode_width", alternate = "qrcodeWidth")
    @JsonProperty(value = "qrcode_width")
    private String qrcodeWidth;

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

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getPassbackParams() {
        return passbackParams;
    }

    public void setPassbackParams(String passbackParams) {
        this.passbackParams = passbackParams;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
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

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getQrPayMode() {
        return qrPayMode;
    }

    public void setQrPayMode(String qrPayMode) {
        this.qrPayMode = qrPayMode;
    }

    public String getQrcodeWidth() {
        return qrcodeWidth;
    }

    public void setQrcodeWidth(String qrcodeWidth) {
        this.qrcodeWidth = qrcodeWidth;
    }

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(goodsType) ? ArrayUtils.contains(GOODS_TYPES, goodsType) : true) && (StringUtils.isNotBlank(qrPayMode) ? ArrayUtils.contains(QR_PAY_MODES, qrPayMode) : true);
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if (StringUtils.isNotBlank(goodsType)) {
            ApplicationHandler.inArray(GOODS_TYPES, goodsType, "goodsType");
        }
        if (StringUtils.isNotBlank(qrPayMode)) {
            ApplicationHandler.inArray(QR_PAY_MODES, qrPayMode, "qrPayMode");
        }
    }

    public static class Builder {
        private AlipayTradePagePayModel instance = new AlipayTradePagePayModel();

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

        public Builder appAuthToken(String appAuthToken) {
            instance.setAppAuthToken(appAuthToken);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder subject(String subject) {
            instance.setSubject(subject);
            return this;
        }

        public Builder body(String body) {
            instance.setBody(body);
            return this;
        }

        public Builder goodsDetail(String goodsDetail) {
            instance.setGoodsDetail(goodsDetail);
            return this;
        }

        public Builder passbackParams(String passbackParams) {
            instance.setPassbackParams(passbackParams);
            return this;
        }

        public Builder goodsType(String goodsType) {
            instance.setGoodsType(goodsType);
            return this;
        }

        public Builder timeoutExpress(String timeoutExpress) {
            instance.setTimeoutExpress(timeoutExpress);
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

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder qrPayMode(String qrPayMode) {
            instance.setQrPayMode(qrPayMode);
            return this;
        }

        public Builder qrcodeWidth(String qrcodeWidth) {
            instance.setQrcodeWidth(qrcodeWidth);
            return this;
        }

        public AlipayTradePagePayModel build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}