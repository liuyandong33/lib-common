package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AlipayFundAuthOrderFreezeModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "auth_code")
    private String authCode;

    @NotNull
    @InList(value = {"bar_code"})
    @JsonProperty(value = "auth_code_type")
    private String authCodeType;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_order_no")
    private String outOrderNo;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_request_no")
    private String outRequestNo;

    @NotNull
    @Length(max = 100)
    @JsonProperty(value = "order_title")
    private String orderTitle;

    @NotNull
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000.00")
    private BigDecimal amount;

    @Length(max = 100)
    @JsonProperty(value = "payee_logon_id")
    private String payeeLogonId;

    @Length(max = 32)
    @JsonProperty(value = "payee_user_id")
    private String payeeUserId;

    @Length(max = 5)
    @JsonProperty(value = "pay_timeout")
    private String payTimeout;

    @Length(max = 300)
    @JsonProperty(value = "extra_param")
    private String extraParam;

    @InList(value = {"PRE_AUTH"})
    @JsonProperty(value = "product_code")
    private String productCode;

    @InList(value = {"AUD", "NZD", "TWD", "USD", "EUR", "GBP"})
    @JsonProperty(value = "trans_currency")
    private String transCurrency;

    @InList(value = {"AUD", "NZD", "TWD", "USD", "EUR", "GBP"})
    @JsonProperty(value = "settle_currency")
    private String settleCurrency;

    @Length(max = 128)
    @JsonProperty(value = "enable_pay_channels")
    private String enablePayChannels;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthCodeType() {
        return authCodeType;
    }

    public void setAuthCodeType(String authCodeType) {
        this.authCodeType = authCodeType;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPayeeLogonId() {
        return payeeLogonId;
    }

    public void setPayeeLogonId(String payeeLogonId) {
        this.payeeLogonId = payeeLogonId;
    }

    public String getPayeeUserId() {
        return payeeUserId;
    }

    public void setPayeeUserId(String payeeUserId) {
        this.payeeUserId = payeeUserId;
    }

    public String getPayTimeout() {
        return payTimeout;
    }

    public void setPayTimeout(String payTimeout) {
        this.payTimeout = payTimeout;
    }

    public String getExtraParam() {
        return extraParam;
    }

    public void setExtraParam(String extraParam) {
        this.extraParam = extraParam;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getTransCurrency() {
        return transCurrency;
    }

    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency;
    }

    public String getSettleCurrency() {
        return settleCurrency;
    }

    public void setSettleCurrency(String settleCurrency) {
        this.settleCurrency = settleCurrency;
    }

    public String getEnablePayChannels() {
        return enablePayChannels;
    }

    public void setEnablePayChannels(String enablePayChannels) {
        this.enablePayChannels = enablePayChannels;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayFundAuthOrderFreezeModel instance = new AlipayFundAuthOrderFreezeModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder authCode(String authCode) {
            instance.setAuthCode(authCode);
            return this;
        }

        public Builder authCodeType(String authCodeType) {
            instance.setAuthCodeType(authCodeType);
            return this;
        }

        public Builder outOrderNo(String outOrderNo) {
            instance.setOutOrderNo(outOrderNo);
            return this;
        }

        public Builder outRequestNo(String outRequestNo) {
            instance.setOutRequestNo(outRequestNo);
            return this;
        }

        public Builder orderTitle(String orderTitle) {
            instance.setOrderTitle(orderTitle);
            return this;
        }

        public Builder amount(BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder payeeLogonId(String payeeLogonId) {
            instance.setPayeeLogonId(payeeLogonId);
            return this;
        }

        public Builder payeeUserId(String payeeUserId) {
            instance.setPayeeUserId(payeeUserId);
            return this;
        }

        public Builder payTimeout(String payTimeout) {
            instance.setPayTimeout(payTimeout);
            return this;
        }

        public Builder extraParam(String extraParam) {
            instance.setExtraParam(extraParam);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder transCurrency(String transCurrency) {
            instance.setTransCurrency(transCurrency);
            return this;
        }

        public Builder settleCurrency(String settleCurrency) {
            instance.setSettleCurrency(settleCurrency);
            return this;
        }

        public Builder enablePayChannels(String enablePayChannels) {
            instance.setEnablePayChannels(enablePayChannels);
            return this;
        }

        public AlipayFundAuthOrderFreezeModel build() {
            AlipayFundAuthOrderFreezeModel alipayFundAuthOrderFreezeModel = new AlipayFundAuthOrderFreezeModel();
            build(alipayFundAuthOrderFreezeModel);
            alipayFundAuthOrderFreezeModel.setAuthCode(instance.getAuthCode());
            alipayFundAuthOrderFreezeModel.setAuthCodeType(instance.getAuthCodeType());
            alipayFundAuthOrderFreezeModel.setOutOrderNo(instance.getOutOrderNo());
            alipayFundAuthOrderFreezeModel.setOutRequestNo(instance.getOutRequestNo());
            alipayFundAuthOrderFreezeModel.setOrderTitle(instance.getOrderTitle());
            alipayFundAuthOrderFreezeModel.setAmount(instance.getAmount());
            alipayFundAuthOrderFreezeModel.setPayeeLogonId(instance.getPayeeLogonId());
            alipayFundAuthOrderFreezeModel.setPayeeUserId(instance.getPayeeUserId());
            alipayFundAuthOrderFreezeModel.setPayTimeout(instance.getPayTimeout());
            alipayFundAuthOrderFreezeModel.setExtraParam(instance.getExtraParam());
            alipayFundAuthOrderFreezeModel.setProductCode(instance.getProductCode());
            alipayFundAuthOrderFreezeModel.setTransCurrency(instance.getTransCurrency());
            alipayFundAuthOrderFreezeModel.setSettleCurrency(instance.getSettleCurrency());
            alipayFundAuthOrderFreezeModel.setEnablePayChannels(instance.getEnablePayChannels());
            return alipayFundAuthOrderFreezeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
